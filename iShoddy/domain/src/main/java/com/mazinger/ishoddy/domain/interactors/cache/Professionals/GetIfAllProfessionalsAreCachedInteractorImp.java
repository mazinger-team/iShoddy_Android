package com.mazinger.ishoddy.domain.interactors.cache.Professionals;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.ref.WeakReference;

public class GetIfAllProfessionalsAreCachedInteractorImp implements GetIfAllProfessionalsAreCachedInteractor
{
    private WeakReference<Context> context;

    public GetIfAllProfessionalsAreCachedInteractorImp(Context context)
    {
        this.context = new WeakReference<Context>(context);
    }

    @Override
    public void execute(Runnable onAllProfessionalsAreCached, Runnable onAllProfessionalsAreNotCached)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context.get());
        boolean professionalsSaved = preferences.getBoolean(SetAllProfessionalsAreCachedInteractorImp.PROFESSIONALS_SAVED, false);

        if (professionalsSaved) {
            onAllProfessionalsAreCached.run();
        } else {
            onAllProfessionalsAreNotCached.run();
        }
    }
}
