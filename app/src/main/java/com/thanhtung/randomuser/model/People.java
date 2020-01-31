package com.thanhtung.randomuser.model;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
import com.thanhtung.randomuser.base.BaseModel;

@Entity(tableName ="People")
public class People extends BaseModel {

    @SerializedName("gender")
    private String gender;

    @Embedded
    @SerializedName("name")
    private Name name;

    @Embedded
    @SerializedName("location")
    private Location location;

    @SerializedName("email")
    private String email;

    @PrimaryKey
    @NonNull
    @SerializedName("phone")
    private String phone;

    @Embedded
    @SerializedName("picture")
    private Picture picture;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
