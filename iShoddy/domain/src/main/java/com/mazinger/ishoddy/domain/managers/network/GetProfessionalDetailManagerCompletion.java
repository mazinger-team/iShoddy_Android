package com.mazinger.ishoddy.domain.managers.network;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.getProfessionalDetail.GetProfessionalDetailResponseType;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public interface GetProfessionalDetailManagerCompletion {


    void completion(@NonNull final GetProfessionalDetailResponseType getProfessionalDetailResponseType);
}
