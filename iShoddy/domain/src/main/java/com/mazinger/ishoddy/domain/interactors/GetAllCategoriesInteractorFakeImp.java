package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;

public class GetAllCategoriesInteractorFakeImp implements GetAllCategoriesInteractor
{
    @Override
    public void execute(@NonNull GetAllCategoriesInteractorCompletion completion, @Nullable InteractorErrorCompletion onError)
    {
        Categories categories = new Categories();

//        categories.add(new Category("Fontaneros"));
//        categories.add(new Category("Electricistas"));
//        categories.add(new Category("Pintores"));
//        categories.add(new Category("Carpinteros"));

        for (int i = 0; i < 10; i++)
        {
            Category category = Category.of(i, "My category " + i, true);
            categories.add(category);
        }

        if (completion != null)
        {
            completion.completion(categories);
        }
    }
}
