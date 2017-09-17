package com.mazinger.ishoddy.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.adapter.CategoryRecyclerViewAdapter;
import com.mazinger.ishoddy.domain.interactors.GetAllCategoriesInteractor;
import com.mazinger.ishoddy.domain.interactors.GetAllCategoriesInteractorCompletion;
import com.mazinger.ishoddy.domain.interactors.GetAllCategoriesInteractorImp;
import com.mazinger.ishoddy.domain.interactors.InteractorErrorCompletion;
import com.mazinger.ishoddy.domain.interactors.bd.DAO.GetAllCategoriesFromCacheManagerDAOImp;
import com.mazinger.ishoddy.domain.interactors.bd.GetAllCategoriesFromCacheInteractor;
import com.mazinger.ishoddy.domain.interactors.bd.GetAllCategoriesFromCacheInteractorImp;
import com.mazinger.ishoddy.domain.interactors.bd.GetAllCategoriesFromCacheManager;
import com.mazinger.ishoddy.domain.interactors.cache.GetIfAllCategoriesAreCachedInteractor;
import com.mazinger.ishoddy.domain.interactors.cache.GetIfAllCategoriesAreCachedInteractorImp;
import com.mazinger.ishoddy.domain.interactors.cache.SaveAllCategoriesIntoCacheInteractor;
import com.mazinger.ishoddy.domain.interactors.cache.SaveAllCategoriesIntoCacheInteractorImp;
import com.mazinger.ishoddy.domain.interactors.cache.SaveAllCategoriesIntoCacheManageDAOImp;
import com.mazinger.ishoddy.domain.interactors.cache.SaveAllCategoriesIntoCacheManager;
import com.mazinger.ishoddy.domain.interactors.cache.SetAllCategoriesAreCachedInteractorImp;
import com.mazinger.ishoddy.domain.interactors.cache.SetAllCategoryAreCachedInteractor;
import com.mazinger.ishoddy.domain.managers.network.GetAllCategoriesManagerImpl;
import com.mazinger.ishoddy.domain.managers.network.NetworkManager;
import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener
{
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.activity_list_categories__progress_bar)
    ProgressBar mProgressBar;

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

        //-- RecyclerView Setup --
        mRecyclerView = (RecyclerView) findViewById(R.id.activity_list_categories_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        //--

        GetIfAllCategoriesAreCachedInteractor getIfAllCategoriesAreCachedInteractor = new GetIfAllCategoriesAreCachedInteractorImp(this);
        getIfAllCategoriesAreCachedInteractor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                // all cached already, no need to download things, just read from DB
                readDataFromCache();
            }
        }, new Runnable()
        {
            @Override
            public void run()
            {
                // nothing cached yet
                obtainCategoryList();
            }
        });
    }

    private void readDataFromCache()
    {
        GetAllCategoriesFromCacheManager getAllCategoriesFromCacheManager = new GetAllCategoriesFromCacheManagerDAOImp(this);
        GetAllCategoriesFromCacheInteractor getAllCategoriesFromCacheInteractor = new GetAllCategoriesFromCacheInteractorImp(getAllCategoriesFromCacheManager);
        getAllCategoriesFromCacheInteractor.execute(new GetAllCategoriesInteractorCompletion()
        {
            @Override
            public void completion(@NonNull Categories categories)
            {
                setupRecyclerView(categories);
            }
        });
    }

    private void obtainCategoryList()
    {
        mProgressBar.setVisibility(View.VISIBLE);

        NetworkManager manager = new GetAllCategoriesManagerImpl(this);
        GetAllCategoriesInteractor getAllCategoriesInteractor = new GetAllCategoriesInteractorImp(manager);
        getAllCategoriesInteractor.execute(
                new GetAllCategoriesInteractorCompletion()
                {
                    @Override
                    public void completion(Categories categories)
                    {
                        //-- Persist in cache all categories --
                        SaveAllCategoriesIntoCacheManager saveManager = new SaveAllCategoriesIntoCacheManageDAOImp(getBaseContext());
                        SaveAllCategoriesIntoCacheInteractor saveAllCategoriesIntoCacheInteractor = new SaveAllCategoriesIntoCacheInteractorImp(saveManager);
                        saveAllCategoriesIntoCacheInteractor.execute(categories, new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                SetAllCategoryAreCachedInteractor setAllCategoryCachedInteractor = new SetAllCategoriesAreCachedInteractorImp(getBaseContext());
                                setAllCategoryCachedInteractor.execute(true);
                            }
                        });

                        setupRecyclerView(categories);
                        mProgressBar.setVisibility(View.INVISIBLE);
                    }
                },
                new InteractorErrorCompletion()
                {
                    @Override
                    public void onError(String errorDescription)
                    {
                        mProgressBar.setVisibility(View.INVISIBLE);
                    }
                }
        );
    }

    private void setupRecyclerView(Categories categories)
    {
        mAdapter = new CategoryRecyclerViewAdapter(getBaseContext(), categories);
        mRecyclerView.setAdapter(mAdapter);

        mCategories = categories;
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






























