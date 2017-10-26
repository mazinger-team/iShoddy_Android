package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.managers.entities.getProfessionalDetail.GetProfessionalDetailResponseType;
import com.mazinger.ishoddy.domain.managers.network.GetProfessionalDetailManager;
import com.mazinger.ishoddy.domain.managers.network.GetProfessionalDetailManagerCompletion;
import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;

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
