package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by davidcavajimenez on 22/9/17.
 */

public interface GetProfessionalDetailInteractor {

    public void execute(@NonNull final GetProfessionalDetailInteractorCompletion completion, @Nullable final InteractorErrorCompletion onError);
}
