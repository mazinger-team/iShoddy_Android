package com.mazinger.ishoddy.fragments;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.domain.interactors.GetProfessionalDetailInteractor;
import com.mazinger.ishoddy.domain.interactors.GetProfessionalDetailInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.GetProfessionalDetailInteractorImpl;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.managers.entities.common.Location;
import com.mazinger.ishoddy.domain.managers.entities.getProfessionalDetail.GetProfessionalDetailResponseType;
import com.mazinger.ishoddy.domain.managers.network.GetProfessionalDetailManager;
import com.mazinger.ishoddy.domain.managers.network.GetProfessionalDetailManagerImpl;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;
import static com.google.android.gms.maps.GoogleMap.MAP_TYPE_NORMAL;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfessionalDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfessionalDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfessionalDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "idProfessional";

    public GoogleMap mMap;
    private MapFragment mMapFragment;


    private String mIdProfessional;


    @BindView(R.id.txt_professionalName)
    public TextView txtProfessionalName;

    @BindView(R.id.txt_coments)
    public TextView txtComents;

    @BindView(R.id.rateValoration)
    public RatingBar rateValoration;

    @BindView(R.id.txt_description)
    public TextView txtDescription;

    @BindView(R.id.viewpager)
    public ViewPager viewpager;

    @BindView(R.id.pageIndicatorView)
    public com.rd.PageIndicatorView mPageIndicatorView;

    @BindView(R.id.img_logo)
    public ImageView imgLogo;

    public ArrayList<String> mPhotos;
    public CustomPagerAdapter mCustomPagerAdapter;

    private static final int TAG_ACCESS_FINE_AND_COARSE = 67;

    private OnFragmentInteractionListener mListener;

    public ProfessionalDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ProfessionalDetailFragment newInstance(String idProfessional) {
        ProfessionalDetailFragment fragment = new ProfessionalDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, idProfessional);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mIdProfessional = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_professional_detail, container, false);

        ButterKnife.bind( this, v );




        mMapFragment = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container_map, mMapFragment, "map");
        fragmentTransaction.commit();

        GetProfessionalDetailManager  professionalManager = new GetProfessionalDetailManagerImpl( getActivity() );
        GetProfessionalDetailInteractor getProfessionalDetailInteractor =  new GetProfessionalDetailInteractorImpl( professionalManager );


        //Recuerda que hay que enviar al servidor el detalle de un profesional => mIdProfessional


        getProfessionalDetailInteractor.execute(new GetProfessionalDetailInteractorCompletion() {
            @Override
            public void completion(@NonNull final GetProfessionalDetailResponseType getProfessionalDetailResponseType) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loadScreen( getProfessionalDetailResponseType );
                        loadingMap( getProfessionalDetailResponseType );
                    }
                });


            }
        }, new InteractorErrorCompletion() {
            @Override
            public void onError(final String errorDescription) {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        ((OnFragmentInteractionListener) getActivity()).onShowError("Error¡",errorDescription);
                    }
                }, 100);



            }
        });



        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void loadScreen( final GetProfessionalDetailResponseType getProfessionalDetailResponseType ){
        txtProfessionalName.setText(getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getCorpName() );
        txtComents.setText( String.valueOf( getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getDemands().size()) + " " + getString(R.string.comments) );

        rateValoration.setRating( getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getRating().floatValue() );
        txtDescription.setText(getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getDescription());

        Picasso.with(getActivity())
                .load(getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getLogoUrl())
                .into(imgLogo);

        mPhotos  = new ArrayList<String>();
        mPhotos =  getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getImagesUrl();
        mCustomPagerAdapter = new CustomPagerAdapter( getActivity() );
        viewpager.setAdapter(mCustomPagerAdapter);
        mPageIndicatorView.setViewPager(viewpager);

    }


    private void loadingMap(final GetProfessionalDetailResponseType getProfessionalDetailResponseType) {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment_container_map);

                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(GoogleMap googleMap) {

                        if (googleMap == null) {
                            Toast.makeText(getActivity().getApplicationContext(),
                                    "Error no hay mapas dispnibles", Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            mMap = googleMap;
                            configureDataToMap();
                            loadProfessionalToMap(getProfessionalDetailResponseType);
                        }
                    }
                });

            }
        });

    }

    public void configureDataToMap() {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION}, TAG_ACCESS_FINE_AND_COARSE);

            return;
        }
        mMap.setBuildingsEnabled(true);
        mMap.setMapType(MAP_TYPE_NORMAL);
        mMap.getUiSettings().setRotateGesturesEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setMyLocationEnabled(true);


    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case TAG_ACCESS_FINE_AND_COARSE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    configureDataToMap();
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void loadProfessionalToMap(final GetProfessionalDetailResponseType getProfessionalDetailResponseType) {

        if (getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getLocation()!=null) {

            Location loc = getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getLocation();

            MarkerOptions markerOptions = new MarkerOptions()
                    .position(new LatLng(loc.getCoordinates().get(0), loc.getCoordinates().get(1)))
                    .title(getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getDescription()).icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));

            mMap.addMarker(markerOptions).setTag(getProfessionalDetailResponseType.getGetProfessionalDetailOutputType().getProfessional().getCorpName());
            CameraPosition cameraPosition = new CameraPosition.Builder().target(
                    new LatLng(loc.getCoordinates().get(0), loc.getCoordinates().get(1))).zoom(10).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }

       /* mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if (marker.getTag() == null || !(marker.getTag() instanceof MyActivity)) {
                    return;
                }
                Steps.goToDetailActivity(MainActivity.this, (MyActivity) marker.getTag());


            }
        });*/

    }




    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        void onShowError(String title, String message);

    }




    class CustomPagerAdapter extends PagerAdapter {

        Context mContext;
        LayoutInflater mLayoutInflater;

        public CustomPagerAdapter(Context context) {
            mContext = context;
            mLayoutInflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mPhotos.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((LinearLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = mLayoutInflater.inflate(R.layout.image_item_pager, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imagePhoto);

            Picasso.with(mContext)
                    .load(mPhotos.get( position ))
                    .placeholder(R.drawable.image_category_placeholder)
                   //  .networkPolicy(NetworkPolicy.)
                    .into(imageView);

            container.addView(itemView);

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((LinearLayout) object);
        }
    }




}
