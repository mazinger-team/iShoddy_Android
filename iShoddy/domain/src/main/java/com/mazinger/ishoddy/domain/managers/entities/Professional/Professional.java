
package com.mazinger.ishoddy.domain.managers.entities.Professional;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mazinger.ishoddy.domain.managers.entities.getProfessionalDetail.Category;

public class Professional {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("corp_name")
    @Expose
    private String corpName;
    @SerializedName("logo_url")
    @Expose
    private String logoUrl;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("reviews_number")
    @Expose
    private Integer reviewsNumber;
    @SerializedName("photo_number")
    @Expose
    private Integer photoNumber;
    @SerializedName("distance")
    @Expose
    private Integer distance;

    public String getId() {
        return id;
    }

    public Professional setId(String id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Professional setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Professional setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getCorpName() {
        return corpName;
    }

    public Professional setCorpName(String corpName) {
        this.corpName = corpName;
        return this;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public Professional setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public Professional setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public Integer getReviewsNumber() {
        return reviewsNumber;
    }

    public Professional setReviewsNumber(Integer reviewsNumber) {
        this.reviewsNumber = reviewsNumber;
        return this;
    }

    public Integer getPhotoNumber() {
        return photoNumber;
    }

    public Professional setPhotoNumber(Integer photoNumber) {
        this.photoNumber = photoNumber;
        return this;
    }

    public Integer getDistance() {
        return distance;
    }

    public Professional setDistance(Integer distance) {
        this.distance = distance;
        return this;
    }
}
