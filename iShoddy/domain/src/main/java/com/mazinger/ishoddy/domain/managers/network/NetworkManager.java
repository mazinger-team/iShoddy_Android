package com.mazinger.ishoddy.domain.managers.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.managers.network.Professionals.GetAllProfessionalsManagerCompletion;

public interface NetworkManager
{
    void getActivitiesFromServer(@NonNull final GetAllCategoriesManagerCompletion completion, @Nullable final ManagerErrorCompletion errorCompletion);
}
