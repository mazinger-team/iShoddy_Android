package com.mazinger.ishoddy.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.adapter.ProfessionalListViewAdapter;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.interactors.Professional.GetAllProfessionalsInteractor;
import com.mazinger.ishoddy.domain.interactors.Professional.GetAllProfessionalsInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.Professional.GetAllProfessionalsInteractorImp;
import com.mazinger.ishoddy.domain.managers.network.Professionals.GetAllAllProfessionalsManagerImpl;
import com.mazinger.ishoddy.domain.managers.network.Professionals.GetAllProfessionalManager;
import com.mazinger.ishoddy.domain.model.Pagination.Pagination;
import com.mazinger.ishoddy.domain.model.Professional.Professional;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;
import com.mazinger.ishoddy.util.EndlessScrollListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfessionalsListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.activity_list_professionals__relativeLayout_linearLayout_progress_bar) ProgressBar mProgressBar;

    GridView mGridView;

    ProfessionalListViewAdapter mProfessionalListViewAdapter = null;
    Professionals mProfessionals = new Professionals();

    String filter = null;
    String order = null;
    String fields = null;

    public Double gps_lat = 0.0;
    public Double gps_lon  = 0.0;

    Boolean loadingStatus = false;

    Pagination mPagination = new Pagination(false).setPaginationKey(0).setPaginationElements(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_professionals);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        obtainProfessionalsList(filter, order, fields, mPagination.getPaginationKey());
    }

    private void obtainProfessionalsList(final String filter, final String order, final String fields, Integer page) {
        if (!loadingStatus) {
            loadingStatus = true;

            mProgressBar.setVisibility(View.VISIBLE);

            obtainPosition();

            GetAllProfessionalManager manager = new GetAllAllProfessionalsManagerImpl(this);
            GetAllProfessionalsInteractor getAllProfessionalsInteractor = new GetAllProfessionalsInteractorImp(manager);
            getAllProfessionalsInteractor.execute(
                    filter, order, fields, page, new GetAllProfessionalsInteractorCompletion() {
                        @Override
                        public void completion(Professionals professionals, Pagination pagination) {
                            mProfessionals.addAll(professionals);
                            mPagination = pagination;
                            mProgressBar.setVisibility(View.INVISIBLE);

                            initializeViews();

                            onScrollListener(filter, order, fields);
                        }
                    },
                    new InteractorErrorCompletion() {
                        @Override
                        public void onError(String errorDescription) {
                            mProgressBar.setVisibility(View.INVISIBLE);
                        }
                    }
            );
        }
    }

    private void obtainPosition() {
        // Se solicitan los permisos al usuario

        if (ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            //showAlert();
            return;
        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        activeLocation(locationManager);
        Criteria criteria = new Criteria();
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        if (location != null) {
            gps_lat = location.getLatitude();
            gps_lon = location.getLongitude();
            if (gps_lat != 0 && gps_lon != 0) {
                filter = "gps_lat=" + gps_lat;
                filter = filter + "&gps_lon=" + gps_lon;
            }
        }
    }

    private void activeLocation(LocationManager mlocManager) {
        final boolean gpsEnabled = mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (!gpsEnabled) {
            Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(settingsIntent);
        }
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Enable Location")
                .setMessage("Su ubicación esta desactivada.\npor favor active su ubicación " + "usa esta app")
                .setPositiveButton("Configuración de ubicación", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        Intent settingsIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(settingsIntent);
                        obtainProfessionalsList(filter, order, fields, mPagination.getPaginationKey());
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    }
                });
        dialog.show();
    }

    private void onScrollListener(final String filter, final String order, final String fields) {
        mGridView.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {
                if (mPagination.getPaginationFlag()) {
                    loadingStatus = false;
                    if (mPagination.getPaginationKey() == 0) {
                        mPagination.setPaginationKey(2);
                    } else {
                        mPagination.setPaginationKey(mPagination.getPaginationKey()+1);
                    }

                    obtainProfessionalsList(filter, order, fields, mPagination.getPaginationKey());
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    private void initializeViews() {
        mGridView = (GridView)findViewById(R.id.activity_list_professionals__relativeLayout_linearLayout_coordinatorLayout_gridView);
        mProfessionalListViewAdapter = new ProfessionalListViewAdapter(getApplicationContext(), mProfessionals);
        mGridView.setAdapter(mProfessionalListViewAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        Professionals newList = new Professionals();

        for (int i = 0; i < mProfessionals.size(); i++) {
            Professional professional = mProfessionals.get(i);
            String name = professional.getCorp_name().toLowerCase();

            if (name.contains(newText)) {
                newList.add(professional);
            }
        }

        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Professional item = (Professional) parent.getItemAtPosition(position);

        Intent intent = new Intent(this, ProfessionalDetailActivity.class);
        intent.putExtra(ProfessionalDetailActivity.EXTRA_PARAM_ID, item.getId());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ActivityOptionsCompat activityOptions =
                    ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this,
                            new Pair<View, String>(view.findViewById(R.id.item_professional_list__professional_logo),
                                    ProfessionalDetailActivity.VIEW_NAME_HEADER_IMAGE)
                    );

            ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
        } else
            startActivity(intent);
    }
}






























