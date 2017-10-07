package com.mazinger.ishoddy.domain.managers.network.Professionals;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.Professional.GetProfessionalResponseType;

public interface GetProfessionalManagerCompletion {
    void completion(@NonNull final GetProfessionalResponseType getProfessionalResponseType);
}
