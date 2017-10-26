package com.mazinger.ishoddy.domain.managers.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by davidcavajimenez on 22/9/17.
 */

public interface GetProfessionalDetailManager {

    public void getProfessionalDetail(@NonNull final GetProfessionalDetailManagerCompletion completion, @Nullable final ManagerErrorCompletion errorCompletion);
}
