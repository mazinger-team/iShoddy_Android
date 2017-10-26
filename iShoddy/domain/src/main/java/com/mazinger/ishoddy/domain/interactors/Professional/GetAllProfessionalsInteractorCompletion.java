package com.mazinger.ishoddy.domain.interactors.Professional;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.model.Pagination.Pagination;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;

public interface GetAllProfessionalsInteractorCompletion {
    void completion(@NonNull final Professionals professionals, Pagination pagination);
}
