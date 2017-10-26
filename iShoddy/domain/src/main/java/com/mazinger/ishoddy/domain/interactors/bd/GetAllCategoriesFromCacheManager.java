package com.mazinger.ishoddy.domain.interactors.bd;

import android.support.annotation.NonNull;

public interface GetAllCategoriesFromCacheManager
{
    void execute(@NonNull final GetAllCategoriesFromCacheManagerCompletion completion);
}
