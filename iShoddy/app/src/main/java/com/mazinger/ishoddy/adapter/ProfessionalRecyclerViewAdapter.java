package com.mazinger.ishoddy.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.mazinger.ishoddy.R;
import com.mazinger.ishoddy.domain.model.Professional.Professional;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;
import com.squareup.picasso.Picasso;

public class ProfessionalRecyclerViewAdapter extends RecyclerView.Adapter<ProfessionalRecyclerViewAdapter.ViewHolder> {
    Professionals mProfessionalList = new Professionals();

    private View.OnClickListener mOnClickListener;
    private Typeface mTextFace = null;
    private Context mContext = null;

    public ProfessionalRecyclerViewAdapter(Context context, Professionals professionalList) {
        mContext = context;
        mProfessionalList = professionalList;

        mTextFace = Typeface.createFromAsset(mContext.getAssets(), "SFText-Regular.otf");
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
    }

    @Override
    public ProfessionalRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_professionals_list, parent, false);

        view.setOnClickListener(mOnClickListener);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfessionalRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.mTextView_Corp_name.setText(mProfessionalList.get(position).getCorp_name());
        holder.mTextView_Corp_name.setTypeface(mTextFace);

        String categoryName = mProfessionalList.get(position).getCategory().getName();
        String upperString = categoryName.substring(0,1).toUpperCase() + categoryName.substring(1).toLowerCase();
        holder.mTextView_Category.setText(upperString);
        holder.mTextView_Category.setTypeface(mTextFace);

        holder.mRatingBar_Rating.setRating(Float.valueOf(String.valueOf(mProfessionalList.get(position).getRating())));

        if (mProfessionalList.get(position).getReviews_number() != 0) {
            holder.mTextView_Num_reviews.setText(String.valueOf(mProfessionalList.get(position).getReviews_number()).concat(" ").concat(mContext.getString(R.string.string_reviews)));
        } else {
            holder.mTextView_Num_reviews.setText(R.string.string_no_reviews);
        }

        holder.mTextView_Num_photos.setText(String.valueOf(mProfessionalList.get(position).getPhoto_number()));
        holder.mTextView_Distance.setText(String.valueOf(mProfessionalList.get(position).getDistance()));

        // TODO: get image using picasso
        if (mProfessionalList.get(position).getLogo_url() != null) {
            Picasso.with(mContext)
                    .load(mProfessionalList.get(position).getLogo_url())
                    .placeholder(R.drawable.professional_logo)
                    //.networkPolicy(NetworkPolicy.OFFLINE)
                    .into(holder.mImageView_Logo);
        }
    }

    @Override
    public int getItemCount() {
        return (int) mProfessionalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView mImageView_Logo;
        private final TextView mTextView_Corp_name;
        private final TextView mTextView_Category;
        private final RatingBar mRatingBar_Rating;
        private final TextView mTextView_Num_reviews;
        private final TextView mTextView_Num_photos;
        private final TextView mTextView_Distance;

        public ViewHolder(View itemView) {
            super(itemView);

            mImageView_Logo = (ImageView) itemView.findViewById(R.id.item_professional_list__professional_logo);
            mTextView_Corp_name = (TextView) itemView.findViewById(R.id.item_professional_list__professional_corp_name);
            mTextView_Category = (TextView) itemView.findViewById(R.id.item_professional_list__professional_category);
            mRatingBar_Rating = (RatingBar) itemView.findViewById(R.id.item_professional_list__professional_ratingbar);
            mTextView_Num_reviews = (TextView) itemView.findViewById(R.id.item_professional_list__professional_rating_count);
            mTextView_Num_photos = (TextView) itemView.findViewById(R.id.item_professional_list__professional_photos_count);
            mTextView_Distance = (TextView) itemView.findViewById(R.id.item_professional_list__professional_dictance_count);
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






























