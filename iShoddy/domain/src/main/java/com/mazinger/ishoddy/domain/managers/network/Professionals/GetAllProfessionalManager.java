package com.mazinger.ishoddy.domain.managers.network.Professionals;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;

public interface GetAllProfessionalManager {
    public void getAllProfessionalFromServer(String filter, String order, String fields, Integer page, @NonNull final GetAllProfessionalsManagerCompletion completion, @Nullable final ManagerErrorCompletion errorCompletion);
}
