package com.mazinger.ishoddy;

import android.support.multidex.MultiDexApplication;
import android.util.Log;
import com.squareup.picasso.Picasso;


public class iShoddyApp extends MultiDexApplication
{

    public static final String APP_NAME = iShoddyApp.class.getCanonicalName();

    @Override
    public void onCreate()
    {
        super.onCreate();

        // init app
        Log.d(APP_NAME, "App starting");

        Picasso.with(getApplicationContext()).setLoggingEnabled(true);
        Picasso.with(getApplicationContext()).setIndicatorsEnabled(true);
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();

        // low memory: dump something
    }
}
