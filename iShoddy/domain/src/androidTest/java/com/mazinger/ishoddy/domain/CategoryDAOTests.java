package com.mazinger.ishoddy.domain;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.mazinger.ishoddy.domain.managers.db.CategoryDAO;
import com.mazinger.ishoddy.domain.model.Category;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class CategoryDAOTests
{
    final static Context appContext = InstrumentationRegistry.getTargetContext();
    public static final int TEST_ID = 888;
    public static final String TEST_NAME = "Masajistas";

    @Test
    public void given_category_DAO_inserts_actvity() throws Exception
    {
        CategoryDAO sut = new CategoryDAO(appContext);

        Category category = Category.of(23, "Maistros albañiles", false);

        long id = sut.insert(category);
        assertTrue(id > 0);
    }

    @Test
    public void given_inserted_categories_DAO_queries_all_categories() throws Exception
    {
        CategoryDAO sut = new CategoryDAO(appContext);
        Category category = insertCategory(sut, 23, "Maistros albañiles", false);

        List<Category> categories = sut.query();

        assertNotNull(categories);
        assertTrue(categories.size() >= 1);
    }

    @Test
    public void given_inserted_categories_deleteall_returns_empty_table() throws Exception
    {
        CategoryDAO sut = new CategoryDAO(appContext);

        insertCategories();
        sut.deleteAll();

        List<Category> categories = sut.query();

        assertNull(categories);
    }

    @Test
    public void given_one_inserted_shop_I_can_delete_that_shop() throws Exception
    {
        CategoryDAO sut = new CategoryDAO(appContext);

        sut.deleteAll();
        insertCategory(sut, TEST_ID, TEST_NAME, true);
        Category category = sut.query(TEST_ID);

        assertEquals(TEST_ID, category.getId());
        assertEquals(TEST_NAME, category.getName());
    }

    private Category insertCategory(CategoryDAO sut, long id, String name, boolean active)
    {
        Category category = Category.of(id, name, active);

        long unique = sut.insert(category);

        return category;
    }

    private void insertCategories()
    {
        CategoryDAO sut = new CategoryDAO(appContext);

        for (int i = 0; i < 10; i++) {
            insertCategory(sut, i, "ProfessionalsCategory " + i, true);
        }
    }
}






























