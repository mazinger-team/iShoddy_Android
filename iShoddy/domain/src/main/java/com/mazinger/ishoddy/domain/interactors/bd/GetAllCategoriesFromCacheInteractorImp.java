package com.mazinger.ishoddy.domain.interactors.bd;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.interactors.GetAllCategoriesInteractorCompletion;
import com.mazinger.ishoddy.domain.model.Categories;

public class GetAllCategoriesFromCacheInteractorImp implements GetAllCategoriesFromCacheInteractor
{

    private GetAllCategoriesFromCacheManager cacheManager;

    public GetAllCategoriesFromCacheInteractorImp(final GetAllCategoriesFromCacheManager cacheManager)
    {
        this.cacheManager = cacheManager;
    }

    @Override
    public void execute(@NonNull final GetAllCategoriesInteractorCompletion completion)
    {
        cacheManager.execute(new GetAllCategoriesFromCacheManagerCompletion()
        {
            @Override
            public void completion(@NonNull Categories categories)
            {
                completion.completion(categories);
            }
        });
    }
}
