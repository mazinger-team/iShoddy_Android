package com.mazinger.ishoddy.domain.interactors.bd;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.interactors.GetAllCategoriesInteractorCompletion;

public interface GetAllCategoriesFromCacheInteractor
{
    void execute(@NonNull final GetAllCategoriesInteractorCompletion completion);
}
