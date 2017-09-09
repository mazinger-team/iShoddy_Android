package com.mazinger.ishoddy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.model.Category;

import java.util.ArrayList;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>
{
    ArrayList<Category> mCategoryList = new ArrayList<>();
    private View.OnClickListener mOnClickListener;

    public CategoryRecyclerViewAdapter(ArrayList<Category> categoryList)
    {
        mCategoryList = categoryList;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {

        mOnClickListener = onClickListener;
    }

    @Override
    public CategoryRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_categories, parent, false);

        view.setOnClickListener(mOnClickListener);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryRecyclerViewAdapter.ViewHolder holder, int position)
    {
        holder.mTextView.setText(mCategoryList.get(position).getName());
    }

    @Override
    public int getItemCount()
    {
        return mCategoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private final TextView mTextView;
        private final ImageView mImageView;

        public ViewHolder(View itemView)
        {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.row_categories_text_name);
            mImageView = (ImageView) itemView.findViewById(R.id.row_categories_image);
        }
    }

    public void setFilter(ArrayList<Category> newList)
    {
        mCategoryList = new ArrayList<>();
        mCategoryList.addAll(newList);
        notifyDataSetChanged();
    }
}






























