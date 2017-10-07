package com.mazinger.ishoddy.domain.interactors.Professional;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.managers.entities.Professional.GetProfessionalResponseType;
import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;
import com.mazinger.ishoddy.domain.managers.network.Professionals.GetProfessionalManager;
import com.mazinger.ishoddy.domain.managers.network.Professionals.GetProfessionalManagerCompletion;

public class GetProfessionalInteractorImpl implements  GetProfessionalInteractor{

    private GetProfessionalManager getProfessionalManager;

    public GetProfessionalInteractorImpl(@NonNull final GetProfessionalManager getProfessionalManager)
    {
        this.getProfessionalManager = getProfessionalManager;
    }

    //@Override
    public void execute(@NonNull final GetProfessionalInteractorCompletion completion, @Nullable final InteractorErrorCompletion onError)
    {
        if (this.getProfessionalManager == null)
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


        this.getProfessionalManager.getProfessional(new GetProfessionalManagerCompletion() {
            @Override
            public void completion(@NonNull GetProfessionalResponseType getProfessionalResponseType) {
                completion.completion(getProfessionalResponseType);
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
