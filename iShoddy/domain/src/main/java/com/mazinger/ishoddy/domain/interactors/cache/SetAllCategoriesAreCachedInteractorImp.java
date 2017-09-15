package com.mazinger.ishoddy.domain.interactors.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.lang.ref.WeakReference;

public class SetAllCategoriesAreCachedInteractorImp implements SetAllCategoryAreCachedInteractor
{
    private WeakReference<Context> context;

    public SetAllCategoriesAreCachedInteractorImp(Context context)
    {
        this.context = new WeakReference<Context>(context);
    }

    @Override
    public void execute(boolean categoriesSaved)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context.get());
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean(SetAllCategoriesAreCachedInteractorImp.CATEGORIES_SAVED, categoriesSaved);

        editor.commit();
    }
}
