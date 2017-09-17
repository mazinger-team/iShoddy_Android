package com.mazinger.ishoddy.domain.interactors.bd;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.model.Categories;

public interface GetAllCategoriesFromCacheManagerCompletion
{
    void completion(@NonNull final Categories categories);
}
