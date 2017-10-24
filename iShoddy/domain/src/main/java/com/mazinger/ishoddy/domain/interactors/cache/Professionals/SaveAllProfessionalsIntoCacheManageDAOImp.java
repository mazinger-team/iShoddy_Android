package com.mazinger.ishoddy.domain.interactors.cache.Professionals;

import android.content.Context;

import com.mazinger.ishoddy.domain.interactors.cache.SaveAllCategoriesIntoCacheManager;
import com.mazinger.ishoddy.domain.managers.db.CategoryDAO;
import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;
import com.mazinger.ishoddy.domain.model.Professional.Professional;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;

import java.lang.ref.WeakReference;

public class SaveAllProfessionalsIntoCacheManageDAOImp implements SaveAllProfessionalsIntoCacheManager
{
    private WeakReference<Context> contextWeakReference;

    public SaveAllProfessionalsIntoCacheManageDAOImp(Context contextWeakReference)
    {
        this.contextWeakReference = new WeakReference<Context>(contextWeakReference);
    }

    /* TODO: Implement when necessary to save this information in BBDD */
    @Override
    public void execute(Professionals professionals, Runnable completion)
    {
        /*
        ProfessionalDAO dao = new ProfessionalDAO(contextWeakReference.get());
        for (ProfessionalsEntity professional : professionals.allProfessionals())
        {
            dao.insert(professional);
        }
        */

        completion.run();
    }
}
