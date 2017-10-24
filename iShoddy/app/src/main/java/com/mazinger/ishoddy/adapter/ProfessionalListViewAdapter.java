package com.mazinger.ishoddy.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.domain.model.Professional.Professional;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;
import com.squareup.picasso.Picasso;

public class ProfessionalListViewAdapter extends BaseAdapter {
    Professionals mProfessionalList = new Professionals();

    private View.OnClickListener mOnClickListener;
    private Typeface mTextFace = null;
    private Context mContext = null;

    public ProfessionalListViewAdapter(Context context, Professionals professionals) {
        mContext = context;
        //mProfessionalList = professionals;
        mProfessionalList = professionals;

        mTextFace = Typeface.createFromAsset(mContext.getAssets(), "SFText-Regular.otf");
    }

    public int getItemCount() {
        return (int) mProfessionalList.size();
    }

    @Override
    public int getCount() {
        return (int)mProfessionalList.size();
    }

    @Override
    public Professional getItem(int position) {
        return mProfessionalList.get((long)position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId().hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Professional professional = mProfessionalList.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_professionals_list, null);

            final ImageView mImageView_Logo = (ImageView) convertView.findViewById(R.id.item_professional_list__professional_logo);
            final TextView mTextView_Corp_name = (TextView) convertView.findViewById(R.id.item_professional_list__professional_corp_name);
            final TextView mTextView_Category = (TextView) convertView.findViewById(R.id.item_professional_list__professional_category);
            final RatingBar mRatingBar_Rating = (RatingBar) convertView.findViewById(R.id.item_professional_list__professional_ratingbar);
            final TextView mTextView_Num_reviews = (TextView) convertView.findViewById(R.id.item_professional_list__professional_rating_count);
            final TextView mTextView_Num_photos = (TextView) convertView.findViewById(R.id.item_professional_list__professional_photos_count);
            final TextView mTextView_Distance = (TextView) convertView.findViewById(R.id.item_professional_list__professional_dictance_count);

            final ViewHolder viewHolder = new ViewHolder(mImageView_Logo, mTextView_Corp_name, mTextView_Category, mRatingBar_Rating, mTextView_Num_reviews, mTextView_Num_photos, mTextView_Distance);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder)convertView.getTag();

        viewHolder.mTextView_Corp_name.setText(professional.getCorp_name());
        viewHolder.mTextView_Corp_name.setTypeface(mTextFace);

        String categoryName = professional.getCategory().getName();
        String upperString = categoryName.substring(0,1).toUpperCase() + categoryName.substring(1).toLowerCase();
        viewHolder.mTextView_Category.setText(upperString);
        viewHolder.mTextView_Category.setTypeface(mTextFace);

        if (professional.getRating() != null) {
            viewHolder.mRatingBar_Rating.setRating(Float.valueOf(String.valueOf(professional.getRating())));
        }

        if (professional.getReviews_number() != null) {
            if (professional.getReviews_number() != 0) {
                viewHolder.mTextView_Num_reviews.setText(String.valueOf(professional.getReviews_number()).concat(" ").concat(mContext.getString(R.string.string_reviews)));
            } else {
                viewHolder.mTextView_Num_reviews.setText(R.string.string_no_reviews);
            }
        }

        if (professional.getPhoto_number() != null) {
            viewHolder.mTextView_Num_photos.setText(String.valueOf(professional.getPhoto_number()));
        }

        if (professional.getDistance() != null) {
            viewHolder.mTextView_Distance.setText(String.valueOf(professional.getDistance()));
        }

        if (mProfessionalList.get(position).getLogo_url() != null) {
            Picasso.with(mContext)
                    .load(professional.getLogo_url())
                    .placeholder(R.drawable.professional_logo)
                    //.networkPolicy(NetworkPolicy.OFFLINE)
                    .into(viewHolder.mImageView_Logo);
        }

        return convertView;
    }

    // Your "view holder" that holds references to each subview
    private class ViewHolder {
        private final ImageView mImageView_Logo;
        private final TextView mTextView_Corp_name;
        private final TextView mTextView_Category;
        private final RatingBar mRatingBar_Rating;
        private final TextView mTextView_Num_reviews;
        private final TextView mTextView_Num_photos;
        private final TextView mTextView_Distance;

        public ViewHolder(ImageView imageView_Logo, TextView textView_Corp_name, TextView textView_Category, RatingBar ratingBar_Rating,
                          TextView textView_Num_reviews, TextView textView_Num_photos, TextView textView_Distance) {
            mImageView_Logo = imageView_Logo;
            mTextView_Corp_name = textView_Corp_name;
            mTextView_Category = textView_Category;
            mRatingBar_Rating = ratingBar_Rating;
            mTextView_Num_reviews = textView_Num_reviews;
            mTextView_Num_photos = textView_Num_photos;
            mTextView_Distance = textView_Distance;
        }
    }

    public void setFilter(Professionals newList) {
        mProfessionalList = new Professionals();

        for (int i = 0; i < newList.size(); i++) {
            Professional professional = newList.get(i);
            mProfessionalList.add(professional);
        }

        notifyDataSetChanged();
    }
}






























