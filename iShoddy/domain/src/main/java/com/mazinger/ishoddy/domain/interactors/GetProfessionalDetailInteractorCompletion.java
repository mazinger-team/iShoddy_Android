package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.GetProfessionalDetailResponseType;
import com.mazinger.ishoddy.domain.model.Categories;

/**
 * Created by davidcavajimenez on 22/9/17.
 */
 public interface GetProfessionalDetailInteractorCompletion {

    void completion(@NonNull final GetProfessionalDetailResponseType getProfessionalDetailResponseType) ;
}
