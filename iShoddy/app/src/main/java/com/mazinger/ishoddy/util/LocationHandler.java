package com.mazinger.ishoddy.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.mazinger.ishoddy.activities.ProfessionalsListActivity;

/**
 * Created by josejacin on 26/10/17.
 */

public class LocationHandler implements LocationListener {
    private ProfessionalsListActivity mProfessionalsListActivity;
    private Location location;

    public ProfessionalsListActivity getProfessionalsListActivity() {
        return mProfessionalsListActivity;
    }

    public void setProfessionalsListActivity(ProfessionalsListActivity mProfessionalsListActivity) {
        this.mProfessionalsListActivity = mProfessionalsListActivity;
    }

    public Location getPosition() {
        return location;
    }

    @Override
    public void onLocationChanged(Location loc) {
        // Este metodo se ejecuta cada vez que el GPS recibe nuevas coordenadas
        // debido a la deteccion de un cambio de ubicacion
        location.setLatitude(loc.getLatitude());
        location.setLongitude(loc.getLongitude());
        this.mProfessionalsListActivity.gps_lon = location.getLongitude();
        this.mProfessionalsListActivity.gps_lat = location.getLatitude();
    }

    @Override
    public void onProviderDisabled(String provider) {
        // Este metodo se ejecuta cuando el GPS es desactivado
    }

    @Override
    public void onProviderEnabled(String provider) {
        // Este metodo se ejecuta cuando el GPS es activado
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        switch (status) {
            case LocationProvider.AVAILABLE:
                Log.d("debug", "LocationProvider.AVAILABLE");
                break;
            case LocationProvider.OUT_OF_SERVICE:
                Log.d("debug", "LocationProvider.OUT_OF_SERVICE");
                break;
            case LocationProvider.TEMPORARILY_UNAVAILABLE:
                Log.d("debug", "LocationProvider.TEMPORARILY_UNAVAILABLE");
                break;
        }
    }

    public static void checkLocationPermissionsAndAdd(@NonNull Activity activity){
        if(activity == null){
            return;
        }

        boolean permissionGranted = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        if(!permissionGranted) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        }
    }
}