package com.mazinger.ishoddy.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;
import com.squareup.picasso.Picasso;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>
{
    Categories mCategoryList = new Categories();

    private View.OnClickListener mOnClickListener;
    private Typeface mTextFace = null;
    private Context mContext = null;

    public CategoryRecyclerViewAdapter(Context context, Categories categoryList)
    {
        mContext = context;
        mCategoryList = categoryList;

        mTextFace = Typeface.createFromAsset(mContext.getAssets(), "SFText-Regular.otf");
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
        String categoryName = mCategoryList.get(position).getName();
        String upperString = categoryName.substring(0,1).toUpperCase() + categoryName.substring(1).toLowerCase();

        holder.mTextView.setText(upperString);
        holder.mTextView.setTypeface(mTextFace);
        //-- TODO: get image using picasso --
        if (mCategoryList.get(position).getUrlLogo() != null)
        {
            Picasso.with(mContext)
                    .load(mCategoryList.get(position).getUrlLogo())
                    .placeholder(R.drawable.image_category_placeholder)
//                    .networkPolicy(NetworkPolicy.OFFLINE)
                    .into(holder.mImageView);
        }
        //--
    }

    @Override
    public int getItemCount()
    {
        return (int) mCategoryList.size();
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

    public void setFilter(Categories newList)
    {
        mCategoryList = new Categories();

        for (int i = 0; i < newList.size(); i++)
        {
            Category category = newList.get(i);
            mCategoryList.add(category);
        }

        notifyDataSetChanged();
    }
}






























