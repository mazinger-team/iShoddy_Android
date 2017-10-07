package com.mazinger.ishoddy.domain.model.Professional;

import com.mazinger.ishoddy.domain.model.Category;

public class Professional
{
    public String id;
    public String user_name;
    public String corp_name;
    public Category category;
    public String logo_url;
    public Double rating;
    public Integer reviews_number;
    public Integer photo_number;
    public Double distance;

    public Professional(String id, String user_name, String corp_name, Category category, String logo_url, Double rating, Integer reviews_number, Integer photo_number, Double distance) {
        this.id = id;
        this.user_name = user_name;
        this.corp_name = corp_name;
        this.category = category;
        this.logo_url = logo_url;
        this.rating = rating;
        this.reviews_number = reviews_number;
        this.photo_number = photo_number;
        this.distance = distance;
    }

    public static Professional of(String id, String user_name, String corp_name, Category category, String logo_url, Double rating, Integer reviews_number, Integer photo_number, Double distance) {

        Professional professional = new Professional(id, user_name, corp_name, category, logo_url, rating, reviews_number, photo_number, distance);

        professional.setId(id);
        professional.setUser_name(user_name);
        professional.setCorp_name(corp_name);
        professional.setCategory(category);
        professional.setLogo_url(logo_url);
        professional.setRating(rating);
        professional.setReviews_number(reviews_number);
        professional.setPhoto_number(photo_number);
        professional.setDistance(distance);

        return professional;
    }

    public String getId() {
        return id;
    }


    public Professional setId(String id) {
        this.id = id;
        return this;
    }

    public String getUser_name() {
        return user_name;
    }

    public Professional setUser_name(String user_name) {
        this.user_name = user_name;
        return this;
    }

    public String getCorp_name() {
        return corp_name;
    }

    public Professional setCorp_name(String corp_name) {
        this.corp_name = corp_name;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Professional setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public Professional setLogo_url(String logo_url) {
        this.logo_url = logo_url;
        return this;
    }

    public Double getRating() {
        return rating;
    }

    public Professional setRating(Double rating) {
        this.rating = rating;
        return this;
    }

    public Integer getReviews_number() {
        return reviews_number;
    }

    public Professional setReviews_number(Integer reviews_number) {
        this.reviews_number = reviews_number;
        return this;
    }

    public Integer getPhoto_number() {
        return photo_number;
    }

    public Professional setPhoto_number(Integer photo_number) {
        this.photo_number = photo_number;
        return this;
    }

    public Double getDistance() {
        return distance;
    }

    public Professional setDistance(Double distance) {
        this.distance = distance;
        return this;
    }



}