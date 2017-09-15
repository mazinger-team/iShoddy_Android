package com.mazinger.ishoddy.domain.interactors.cache;

public interface SetAllCategoryAreCachedInteractor
{
    public static final String CATEGORIES_SAVED = "CATEGORIES_SAVED";

    void execute(boolean categoriesSaved);
}
