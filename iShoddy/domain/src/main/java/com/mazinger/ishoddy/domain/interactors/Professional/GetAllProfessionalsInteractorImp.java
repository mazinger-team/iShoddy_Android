package com.mazinger.ishoddy.domain.interactors.Professional;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.managers.entities.Professional.ProfessionalsEntity;
import com.mazinger.ishoddy.domain.managers.entities.common.PaginationData.PaginationDataEntity;
import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;
import com.mazinger.ishoddy.domain.managers.network.Pagination.PaginationEntityIntoPaginationMapper;
import com.mazinger.ishoddy.domain.managers.network.Professionals.GetAllProfessionalManager;
import com.mazinger.ishoddy.domain.managers.network.Professionals.GetAllProfessionalsManagerCompletion;
import com.mazinger.ishoddy.domain.managers.network.Professionals.ProfessionalEntityIntoProfessionalsMapper;
import com.mazinger.ishoddy.domain.model.Pagination.Pagination;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;

import java.util.List;

public class GetAllProfessionalsInteractorImp implements GetAllProfessionalsInteractor {
    private GetAllProfessionalManager mGetAllProfessionalManager;

    public GetAllProfessionalsInteractorImp(@NonNull final GetAllProfessionalManager getAllProfessionalManager) {
        this.mGetAllProfessionalManager = getAllProfessionalManager;
    }

    @Override
    public void execute(String filter, String order, String fields, Integer page, @NonNull final GetAllProfessionalsInteractorCompletion completion, @Nullable final InteractorErrorCompletion onError) {
        if (this.mGetAllProfessionalManager == null) {
            if (onError == null) {
                throw new IllegalStateException("Network manager can't be null");
            } else {
                onError.onError("");
            }
        }

        this.mGetAllProfessionalManager.getAllProfessionalFromServer(
                filter, order, fields, page,
                new GetAllProfessionalsManagerCompletion() {
                    @Override
                    public void completion(@NonNull List<ProfessionalsEntity> professionalsEntities, @NonNull PaginationDataEntity paginationDataEntity) {
                        if(completion != null) {
                            Professionals professionals = ProfessionalEntityIntoProfessionalsMapper.map(professionalsEntities);
                            Pagination pagination = PaginationEntityIntoPaginationMapper.getPagination(paginationDataEntity);
                            completion.completion(professionals, pagination);
                        }
                    }
                },
                new ManagerErrorCompletion() {
                    @Override
                    public void onError(String errorDescription) {
                        if (onError != null) {
                            onError.onError(errorDescription);
                        }
                    }
                }
        );
    }
}
