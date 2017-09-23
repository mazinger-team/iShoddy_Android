package com.mazinger.ishoddy.domain.managers.entities;

import com.google.gson.annotations.SerializedName;
import com.mazinger.ishoddy.domain.managers.entities.common.Localization;

import java.util.ArrayList;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class GetProfessionalDetailOutputType
{

    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("rate")
    private double rate;
    @SerializedName("photos")
    private ArrayList<String> photos;
    @SerializedName("localization")
    private Localization localization;
    @SerializedName("logo")
    private String logo;
    @SerializedName("naphoneNumberme")
    private String phoneNumber;
    @SerializedName("numberOfComments")
    private int numberOfComments;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public ArrayList<String> getPhotos() {
        return this.photos;
    }

    public void setPhotos(ArrayList<String> photos) {
        this.photos = photos;
    }

    public Localization getLocalization() {
        return this.localization;
    }

    public void setLocalization(Localization localization) {
        this.localization = localization;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getNumberOfComments() {
        return this.numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }




}
