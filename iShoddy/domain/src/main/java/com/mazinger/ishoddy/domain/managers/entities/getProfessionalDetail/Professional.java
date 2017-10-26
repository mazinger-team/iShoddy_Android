
package com.mazinger.ishoddy.domain.managers.entities.getProfessionalDetail;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mazinger.ishoddy.domain.managers.entities.common.Location2;

public class Professional {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("subcategory")
    @Expose
    private Subcategory subcategory;
    @SerializedName("corp_name")
    @Expose
    private String corpName;
    @SerializedName("logo_url")
    @Expose
    private String logoUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("fiscal_id")
    @Expose
    private String fiscalId;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("postal_code")
    @Expose
    private String postalCode;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("location")
    @Expose
    private Location2 location;
    @SerializedName("web_url")
    @Expose
    private String webUrl;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("telephone")
    @Expose
    private String telephone;
    @SerializedName("opening_hours")
    @Expose
    private String openingHours;
    @SerializedName("register_date")
    @Expose
    private String registerDate;
    @SerializedName("rate_visit")
    @Expose
    private Integer rateVisit;
    @SerializedName("rate_hour")
    @Expose
    private Integer rateHour;
    @SerializedName("rate_notes")
    @Expose
    private String rateNotes;
    @SerializedName("rating_accumulated")
    @Expose
    private Integer ratingAccumulated;
    @SerializedName("rating_votes")
    @Expose
    private Integer ratingVotes;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("reviews_number")
    @Expose
    private Integer reviewsNumber;
    @SerializedName("photo_number")
    @Expose
    private Integer photoNumber;
    @SerializedName("images_url")
    @Expose
    private ArrayList<String> imagesUrl = null;
    @SerializedName("demands")
    @Expose
    private List<String> demands = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFiscalId() {
        return fiscalId;
    }

    public void setFiscalId(String fiscalId) {
        this.fiscalId = fiscalId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Location2 getLocation() {
        return location;
    }

    public void setLocation(Location2 location) {
        this.location = location;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getRateVisit() {
        return rateVisit;
    }

    public void setRateVisit(Integer rateVisit) {
        this.rateVisit = rateVisit;
    }

    public Integer getRateHour() {
        return rateHour;
    }

    public void setRateHour(Integer rateHour) {
        this.rateHour = rateHour;
    }

    public String getRateNotes() {
        return rateNotes;
    }

    public void setRateNotes(String rateNotes) {
        this.rateNotes = rateNotes;
    }

    public Integer getRatingAccumulated() {
        return ratingAccumulated;
    }

    public void setRatingAccumulated(Integer ratingAccumulated) {
        this.ratingAccumulated = ratingAccumulated;
    }

    public Integer getRatingVotes() {
        return ratingVotes;
    }

    public void setRatingVotes(Integer ratingVotes) {
        this.ratingVotes = ratingVotes;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getReviewsNumber() {
        return reviewsNumber;
    }

    public void setReviewsNumber(Integer reviewsNumber) {
        this.reviewsNumber = reviewsNumber;
    }

    public Integer getPhotoNumber() {
        return photoNumber;
    }

    public void setPhotoNumber(Integer photoNumber) {
        this.photoNumber = photoNumber;
    }

    public ArrayList<String> getImagesUrl() {
        return imagesUrl;
    }

    public void setImagesUrl(ArrayList<String> imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public List<String> getDemands() {
        return demands;
    }

    public void setDemands(List<String> demands) {
        this.demands = demands;
    }

}
