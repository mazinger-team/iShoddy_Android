package com.mazinger.ishoddy.domain.interactors.cache;

public interface GetIfAllCategoriesAreCachedInteractor
{
    void execute(Runnable onAllCategoriesAreCached, Runnable onAllCategoriesAreNotCached);
}
