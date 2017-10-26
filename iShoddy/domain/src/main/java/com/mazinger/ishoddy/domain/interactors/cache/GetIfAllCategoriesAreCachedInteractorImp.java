package com.mazinger.ishoddy.domain.interactors.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.ref.WeakReference;

public class GetIfAllCategoriesAreCachedInteractorImp implements GetIfAllCategoriesAreCachedInteractor
{
    private WeakReference<Context> context;

    public GetIfAllCategoriesAreCachedInteractorImp(Context context)
    {
        this.context = new WeakReference<Context>(context);
    }

    @Override
    public void execute(Runnable onAllCategoriesAreCached, Runnable onAllCategoriesAreNotCached)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context.get());
        boolean categoriesSaved = preferences.getBoolean(SetAllCategoriesAreCachedInteractorImp.CATEGORIES_SAVED, false);

        if (categoriesSaved) {
            onAllCategoriesAreCached.run();
        } else {
            onAllCategoriesAreNotCached.run();
        }
    }
}
