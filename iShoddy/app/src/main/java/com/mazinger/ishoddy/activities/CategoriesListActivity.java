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
import com.mazinger.ishoddy.model.Category;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener
{
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    RecyclerView mRecyclerView;
    CategoryRecyclerViewAdapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Category> mArrayList = new ArrayList<>();

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

        mArrayList.add(new Category("Fontaneros"));
        mArrayList.add(new Category("Electricistas"));
        mArrayList.add(new Category("Pintores"));
        mArrayList.add(new Category("Carpinteros"));

        mAdapter = new CategoryRecyclerViewAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);
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
        ArrayList<Category> newList = new ArrayList<>();

        for (Category category : mArrayList)
        {
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






























