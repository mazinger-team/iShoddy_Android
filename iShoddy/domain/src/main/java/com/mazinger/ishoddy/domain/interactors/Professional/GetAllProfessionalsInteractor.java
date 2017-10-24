package com.mazinger.ishoddy.domain.interactors.Professional;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.interactors.Professional.GetAllProfessionalsInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;

public interface GetAllProfessionalsInteractor {
    public void execute(String filter, String order, String fields, Integer page, @NonNull final GetAllProfessionalsInteractorCompletion completion, @Nullable final InteractorErrorCompletion onError);
}
