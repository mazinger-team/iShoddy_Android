package com.mazinger.ishoddy.domain.interactors.cache;

import com.mazinger.ishoddy.domain.model.Categories;

public class SaveAllCategoriesIntoCacheInteractorImp implements SaveAllCategoriesIntoCacheInteractor
{
    private SaveAllCategoriesIntoCacheManager manager;

    public SaveAllCategoriesIntoCacheInteractorImp(SaveAllCategoriesIntoCacheManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void execute(Categories categories, Runnable completion)
    {
        manager.execute(categories, completion);
    }
}
