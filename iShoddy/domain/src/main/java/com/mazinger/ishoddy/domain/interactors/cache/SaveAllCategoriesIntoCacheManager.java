package com.mazinger.ishoddy.domain.interactors.cache;

import com.mazinger.ishoddy.domain.model.Categories;

public interface SaveAllCategoriesIntoCacheManager
{
    void execute(Categories categories, Runnable completion);
}
