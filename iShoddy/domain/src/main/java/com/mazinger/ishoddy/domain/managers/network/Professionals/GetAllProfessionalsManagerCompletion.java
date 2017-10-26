package com.mazinger.ishoddy.domain.managers.network.Professionals;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.Professional.ProfessionalsEntity;
import com.mazinger.ishoddy.domain.managers.entities.common.PaginationData.PaginationDataEntity;

import java.util.List;

public interface GetAllProfessionalsManagerCompletion {
    void completion(@NonNull final List<ProfessionalsEntity> professionalEntities, @NonNull final PaginationDataEntity paginationDataEntity);
}
