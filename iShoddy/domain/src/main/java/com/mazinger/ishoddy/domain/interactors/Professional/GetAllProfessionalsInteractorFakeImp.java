package com.mazinger.ishoddy.domain.interactors.Professional;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.model.Category;
import com.mazinger.ishoddy.domain.model.Pagination.Pagination;
import com.mazinger.ishoddy.domain.model.Professional.Professional;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;

public class GetAllProfessionalsInteractorFakeImp implements GetAllProfessionalsInteractor {
    @Override
    public void execute(String filter, String order, String fields, Integer page, @NonNull GetAllProfessionalsInteractorCompletion completion, @Nullable InteractorErrorCompletion onError) {
        Professionals professionals = new Professionals();
        Pagination pagination = Pagination.of(true, 2, 10);

        for (int i = 0; i < 10; i++) {
            Category category = Category.of(i, "My category " + i, true);
            Professional professional = Professional.of(String.valueOf(i), "My professional " + i, "My corp name " + i, category, "logo", 4.0, 4, 4, 4.0);
            professionals.add(professional);
        }

        if (completion != null) {
            completion.completion(professionals, pagination);
        }
    }
}
