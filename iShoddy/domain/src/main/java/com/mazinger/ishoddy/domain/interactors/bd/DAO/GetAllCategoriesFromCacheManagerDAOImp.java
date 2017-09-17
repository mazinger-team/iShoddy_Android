package com.mazinger.ishoddy.domain.interactors.bd.DAO;

import android.content.Context;
import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.interactors.bd.GetAllCategoriesFromCacheManager;
import com.mazinger.ishoddy.domain.interactors.bd.GetAllCategoriesFromCacheManagerCompletion;
import com.mazinger.ishoddy.domain.managers.db.CategoryDAO;
import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;

import java.lang.ref.WeakReference;
import java.util.List;

public class GetAllCategoriesFromCacheManagerDAOImp implements GetAllCategoriesFromCacheManager
{
    private WeakReference<Context> mContextWeakReference;

    public GetAllCategoriesFromCacheManagerDAOImp(Context context)
    {
        mContextWeakReference = new WeakReference<Context>(context);
    }

    @Override
    public void execute(@NonNull GetAllCategoriesFromCacheManagerCompletion completion)
    {
        CategoryDAO dao = new CategoryDAO(mContextWeakReference.get());
        List<Category> categoryList = dao.query();

        if (categoryList == null)
        {
            return;
        }

        Categories categories = Categories.from(categoryList);
        completion.completion(categories);
    }
}
