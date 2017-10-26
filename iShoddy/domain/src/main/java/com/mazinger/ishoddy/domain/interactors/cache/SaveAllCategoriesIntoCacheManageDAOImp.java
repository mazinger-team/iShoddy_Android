package com.mazinger.ishoddy.domain.interactors.cache;

import android.content.Context;

import com.mazinger.ishoddy.domain.managers.db.CategoryDAO;
import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;

import java.lang.ref.WeakReference;

public class SaveAllCategoriesIntoCacheManageDAOImp implements SaveAllCategoriesIntoCacheManager
{
    private WeakReference<Context> contextWeakReference;

    public SaveAllCategoriesIntoCacheManageDAOImp(Context contextWeakReference)
    {
        this.contextWeakReference = new WeakReference<Context>(contextWeakReference);
    }

    @Override
    public void execute(Categories categories, Runnable completion)
    {
        CategoryDAO dao = new CategoryDAO(contextWeakReference.get());
        for (Category category : categories.allCategories())
        {
            dao.insert(category);
        }

        completion.run();
    }
}
