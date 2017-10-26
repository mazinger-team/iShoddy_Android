package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface GetAllCategoriesInteractor
{
    public void execute(@NonNull final GetAllCategoriesInteractorCompletion completion, @Nullable final InteractorErrorCompletion onError);
}
