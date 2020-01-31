package com.thanhtung.randomuser.model;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Location")
public class Location {
    @SerializedName("city")
    private String city;

    @SerializedName("country")
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
