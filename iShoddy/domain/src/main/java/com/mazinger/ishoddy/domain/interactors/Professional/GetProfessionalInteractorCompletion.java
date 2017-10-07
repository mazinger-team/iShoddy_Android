package com.mazinger.ishoddy.domain.interactors.Professional;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.Professional.GetProfessionalResponseType;

public interface GetProfessionalInteractorCompletion {
    void completion(@NonNull final GetProfessionalResponseType getProfessionalResponseType) ;
}
