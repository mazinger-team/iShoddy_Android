package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;
import com.mazinger.ishoddy.domain.managers.entities.GetProfessionalDetailResponseType;
import com.mazinger.ishoddy.domain.managers.network.CategoryEntityIntoCategoriesMapper;
import com.mazinger.ishoddy.domain.managers.network.GetAllCategoriesManagerCompletion;
import com.mazinger.ishoddy.domain.managers.network.GetProfessionalDetailManager;
import com.mazinger.ishoddy.domain.managers.network.GetProfessionalDetailManagerCompletion;
import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;
import com.mazinger.ishoddy.domain.managers.network.NetworkManager;
import com.mazinger.ishoddy.domain.model.Categories;

import java.util.List;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class GetProfessionalDetailInteractorImpl  implements  GetProfessionalDetailInteractor{

    private GetProfessionalDetailManager getProfessionalDetailManager;

    public GetProfessionalDetailInteractorImpl(@NonNull final GetProfessionalDetailManager getProfessionalDetailManager)
    {
        this.getProfessionalDetailManager = getProfessionalDetailManager;
    }

    //@Override
    public void execute(@NonNull final GetProfessionalDetailInteractorCompletion completion, @Nullable final InteractorErrorCompletion onError)
    {
        if (this.getProfessionalDetailManager == null)
        {
            if (onError == null)
            {
                throw new IllegalStateException("Network manager can't be null");
            }
            else
            {
                onError.onError("");
            }
        }


        this.getProfessionalDetailManager.getProfessionalDetail(new GetProfessionalDetailManagerCompletion() {
            @Override
            public void completion(@NonNull GetProfessionalDetailResponseType getProfessionalDetailResponseType) {
                completion.completion(getProfessionalDetailResponseType);
            }
        }, new ManagerErrorCompletion() {
            @Override
            public void onError(String errorDescription)
            {
                if (onError != null)
                {
                    onError.onError(errorDescription);
                }
            }
        });

    }
}
