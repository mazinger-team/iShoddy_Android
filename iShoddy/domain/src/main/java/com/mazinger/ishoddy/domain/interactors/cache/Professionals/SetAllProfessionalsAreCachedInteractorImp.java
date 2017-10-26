package com.mazinger.ishoddy.domain.interactors.cache.Professionals;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mazinger.ishoddy.domain.interactors.cache.SetAllCategoryAreCachedInteractor;

import java.lang.ref.WeakReference;

public class SetAllProfessionalsAreCachedInteractorImp implements SetAllProfessionalAreCachedInteractor
{
    private WeakReference<Context> context;

    public SetAllProfessionalsAreCachedInteractorImp(Context context)
    {
        this.context = new WeakReference<Context>(context);
    }

    @Override
    public void execute(boolean professionalSaved)
    {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context.get());
        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean(SetAllProfessionalsAreCachedInteractorImp.PROFESSIONALS_SAVED, professionalSaved);

        editor.commit();
    }
}
