package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.model.Categories;

public interface GetAllCategoriesInteractorCompletion
{
    void completion(@NonNull final Categories categories);
}
