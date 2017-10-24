package com.mazinger.ishoddy.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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

public class ProfessionalsListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener
{
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.activity_list_professionals__relativeLayout_linearLayout_progress_bar) ProgressBar mProgressBar;

    //RecyclerView mRecyclerView;
    GridView mGridView;

    //ProfessionalRecyclerViewAdapter mRecyclerViewAdapter;
    ProfessionalListViewAdapter mProfessionalListViewAdapter = null;
    //RecyclerView.LayoutManager mLayoutManager;
    Professionals mProfessionals = new Professionals();

    String filter = null;
    String order = null;
    String fields = null;

    Double gps_lat = 0.0;
    Double gps_lon  = 0.0;

    Integer page = 0;

    Boolean loadingStatus = false;

    Pagination mPagination = new Pagination(false).setPaginationKey(0).setPaginationElements(10);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_professionals);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        obtainProfessionalsList(filter, order, fields, mPagination.getPaginationKey());

        mGridView = (GridView)findViewById(R.id.activity_list_professionals__relativeLayout_linearLayout_coordinatorLayout_gridView);
        mProfessionalListViewAdapter = new ProfessionalListViewAdapter(getApplicationContext(), mProfessionals);
        mGridView.setAdapter(mProfessionalListViewAdapter);

    }

    private void obtainProfessionalsList(final String filter, final String order, final String fields, Integer page) {
        if (!loadingStatus) {
            loadingStatus = true;

            mProgressBar.setVisibility(View.VISIBLE);

        /*

        // If location services is enabled get the users location
        if CLLocationManager.locationServicesEnabled() {
            locationManager = CLLocationManager()
            locationManager?.requestWhenInUseAuthorization()
            locationManager?.delegate = self
            locationManager?.desiredAccuracy = kCLLocationAccuracyBest // You can change the locaiton accuary here.
            locationManager?.startUpdatingLocation()
            locationManager?.requestLocation()
            if let location = locationManager?.location?.coordinate {
                gps_lat = location.latitude
                gps_lon = location.longitude
            }
        }

        automaticallyAdjustsScrollViewInsets = false

        if (gps_lat != 0 && gps_lon != 0) {
            filter = "gps_lat=" + String(describing: gps_lat!)
            filter = filter! + "&gps_lon=" + String(describing: gps_lon!)
        }


         */
        GetAllProfessionalManager manager = new GetAllAllProfessionalsManagerImpl(this);
        GetAllProfessionalsInteractor getAllProfessionalsInteractor = new GetAllProfessionalsInteractorImp(manager);
        getAllProfessionalsInteractor.execute(
                filter, order, fields, page, new GetAllProfessionalsInteractorCompletion() {
                    @Override
                    public void completion(Professionals professionals, Pagination pagination)
                    {
                        //setupRecyclerView(professionals);
                        mProfessionals.addAll(professionals);
                        mPagination = pagination;
                        mProgressBar.setVisibility(View.INVISIBLE);



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
                },
                new InteractorErrorCompletion()
                {
                    @Override
                    public void onError(String errorDescription)
                    {
                        mProgressBar.setVisibility(View.INVISIBLE);
                    }
                }
        );

        /*
        if CLLocationManager.locationServicesEnabled() {
            locationManager?.stopUpdatingLocation()
        }
         */
        }
    }

    private void setupRecyclerView(Professionals professionals)
    {
        //mRecyclerViewAdapter = new ProfessionalRecyclerViewAdapter(getBaseContext(), professionals);
        //mRecyclerView.setAdapter(mRecyclerViewAdapter);

        mProfessionals = professionals;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
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
    public boolean onQueryTextChange(String newText)
    {
        newText = newText.toLowerCase();
        Professionals newList = new Professionals();

        for (int i = 0; i < mProfessionals.size(); i++)
        {
            Professional professional = mProfessionals.get(i);
            String name = professional.getCorp_name().toLowerCase();

            if (name.contains(newText))
            {
                newList.add(professional);
            }
        }

        //mRecyclerViewAdapter.setFilter(newList);

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

      /*
    @NonNull
    private InfiniteScrollListener createInfiniteScrollListener() {
        return new InfiniteScrollListener(MAX_ITEMS_PER_REQUEST, layoutManager) {
            @Override public void onScrolledToEnd(final int firstVisibleItemPosition) {
                simulateLoading();
                int start = ++page * MAX_ITEMS_PER_REQUEST;
                final boolean allItemsLoaded = start >= items.size();
                if (allItemsLoaded) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    int end = start + MAX_ITEMS_PER_REQUEST;
                    final List<String> itemsLocal = getItemsToBeLoaded(start, end);
                    refreshView(recyclerView, new MyAdapter(itemsLocal), firstVisibleItemPosition);
                }
            }
        };
    }
*/
}






























