package com.mazinger.ishoddy.domain.interactors.Professional;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;

public interface GetProfessionalInteractor {
    public void execute(@NonNull final GetProfessionalInteractorCompletion completion, @Nullable final InteractorErrorCompletion onError);
}
