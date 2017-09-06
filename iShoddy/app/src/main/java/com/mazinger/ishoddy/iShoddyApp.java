package com.mazinger.ishoddy;

import android.support.multidex.MultiDexApplication;
import android.util.Log;


public class iShoddyApp extends MultiDexApplication
{

    public static final String APP_NAME = iShoddyApp.class.getCanonicalName();

    @Override
    public void onCreate()
    {
        super.onCreate();

        // init app
        Log.d(APP_NAME, "App starting");
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();

        // low memory: dump something
    }
}
