package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;
import com.mazinger.ishoddy.domain.managers.network.CategoryEntityIntoCategoriesMapper;
import com.mazinger.ishoddy.domain.managers.network.GetAllCategoriesManagerCompletion;
import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;
import com.mazinger.ishoddy.domain.managers.network.NetworkManager;
import com.mazinger.ishoddy.domain.model.Categories;

import java.util.List;

public class GetAllCategoriesInteractorImp implements GetAllCategoriesInteractor
{
    private NetworkManager networkManager;

    public GetAllCategoriesInteractorImp(@NonNull final NetworkManager networkManager)
    {
        this.networkManager = networkManager;
    }

    @Override
    public void execute(@NonNull final GetAllCategoriesInteractorCompletion completion, @Nullable final InteractorErrorCompletion onError)
    {
        if (this.networkManager == null)
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

        this.networkManager.getActivitiesFromServer(

                new GetAllCategoriesManagerCompletion()
                {
                    @Override
                    public void completion(@NonNull List<CategoryEntity> categoryEntities)
                    {
//                        Log.d("CATEGORY", categoryEntities.toString());
                        if(completion != null)
                        {
                            Categories categories = CategoryEntityIntoCategoriesMapper.map(categoryEntities);
                            completion.completion(categories);
                        }
                    }
                },
                new ManagerErrorCompletion()
                {
                    @Override
                    public void onError(String errorDescription)
                    {
                        if (onError != null)
                        {
                            onError.onError(errorDescription);
                        }
                    }
                }
        );
    }
}






























