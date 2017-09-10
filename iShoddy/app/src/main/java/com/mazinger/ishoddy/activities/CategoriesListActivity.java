package com.mazinger.ishoddy.activities;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.adapter.CategoryRecyclerViewAdapter;
import com.mazinger.ishoddy.domain.interactors.GetAllCategoriesInteractor;
import com.mazinger.ishoddy.domain.interactors.GetAllCategoriesInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.GetAllCategoriesInteractorFakeImp;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener
{
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    RecyclerView mRecyclerView;
    CategoryRecyclerViewAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Categories mCategories = new Categories();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_categories);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_list_categories_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);

        //-- Interactor --
        GetAllCategoriesInteractor getAllCategoriesInteractor = new GetAllCategoriesInteractorFakeImp();
        getAllCategoriesInteractor.execute(
                new GetAllCategoriesInteractorCompletion()
                {
                    @Override
                    public void completion(Categories categories)
                    {
                        mAdapter = new CategoryRecyclerViewAdapter(getBaseContext(), categories);
                        mRecyclerView.setAdapter(mAdapter);

                        mCategories = categories;
                    }
                },
                new InteractorErrorCompletion()
                {
                    @Override
                    public void onError(String errorDescription)
                    {

                    }
                }
        );
        //--
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_items, menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText)
    {
        newText = newText.toLowerCase();
        Categories newList = new Categories();

        for (int i = 0; i < mCategories.size(); i++)
        {
            Category category = mCategories.get(i);
            String name = category.getName().toLowerCase();

            if (name.contains(newText))
            {
                newList.add(category);
            }
        }

        mAdapter.setFilter(newList);

        return true;
    }
}






























