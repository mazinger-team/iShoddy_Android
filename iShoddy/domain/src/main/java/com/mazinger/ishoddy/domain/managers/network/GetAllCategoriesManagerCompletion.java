package com.mazinger.ishoddy.domain.managers.network;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;

import java.util.List;

public interface GetAllCategoriesManagerCompletion
{
    // TODO: quitar categories de aquí
    void completion(@NonNull final List<CategoryEntity> categoryEntities);
}
