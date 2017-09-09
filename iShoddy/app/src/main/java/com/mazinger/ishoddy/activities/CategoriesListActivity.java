package com.mazinger.ishoddy.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.adapter.CategoryRecyclerViewAdapter;
import com.mazinger.ishoddy.model.Category;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesListActivity extends AppCompatActivity
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

        mAdapter = new CategoryRecyclerViewAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);
    }
}






























