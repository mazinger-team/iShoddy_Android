package com.mazinger.ishoddy.domain.managers.network.Professionals;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;

public interface GetProfessionalManager {

    public void getProfessional(@NonNull final GetProfessionalManagerCompletion completion, @Nullable final ManagerErrorCompletion errorCompletion);
}
