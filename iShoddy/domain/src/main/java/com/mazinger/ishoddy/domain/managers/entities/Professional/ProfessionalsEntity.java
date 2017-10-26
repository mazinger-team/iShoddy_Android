
package com.mazinger.ishoddy.domain.managers.entities.Professional;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mazinger.ishoddy.domain.model.Category;

public class ProfessionalsEntity {

    @SerializedName("_id") @Expose private String id;
    @SerializedName("user_name") @Expose private String userName;
    @SerializedName("category") @Expose private Category category;
    @SerializedName("corp_name") @Expose private String corpName;
    @SerializedName("logo_url") @Expose private String logoUrl;
    @SerializedName("rating") @Expose private Double rating;
    @SerializedName("reviews_number") @Expose private Integer reviewsNumber;
    @SerializedName("photo_number") @Expose private Integer photoNumber;
    @SerializedName("distance") @Expose private Double distance;

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public Category getCategory() {
        return category;
    }

    public String getCorpName() {
        return corpName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getReviewsNumber() {
        return reviewsNumber;
    }

    public Integer getPhotoNumber() {
        return photoNumber;
    }

    public Double getDistance() {
        return distance;
    }
}
