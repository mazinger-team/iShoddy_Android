package com.mazinger.ishoddy.domain.managers.network;

import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;
import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;

import java.util.List;

public class CategoryEntityIntoCategoriesMapper
{
    public static Categories map(List<CategoryEntity> categoryEntities)
    {
        Categories categories = new Categories();

        for (CategoryEntity categoryEntity : categoryEntities)
        {
            Category category = new Category(categoryEntity.getName())
                    .setId(categoryEntity.getId())
                    .setActive(categoryEntity.isActive())
                    .setModificationDate(categoryEntity.getModificationDate())
                    .setUrlLogo(categoryEntity.getUrlLogo());

            categories.add(category);
        }

        return categories;
    }
}
