package com.mazinger.ishoddy.domain.interactors.cache;

import com.mazinger.ishoddy.domain.model.Categories;

public interface SaveAllCategoriesIntoCacheInteractor
{
    void execute(Categories categories, Runnable completion);
}
