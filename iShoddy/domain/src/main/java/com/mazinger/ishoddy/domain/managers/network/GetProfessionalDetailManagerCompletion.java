package com.mazinger.ishoddy.domain.managers.network;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;
import com.mazinger.ishoddy.domain.managers.entities.GetProfessionalDetailResponseType;

import java.util.List;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public interface GetProfessionalDetailManagerCompletion {


    void completion(@NonNull final GetProfessionalDetailResponseType getProfessionalDetailResponseType);
}
