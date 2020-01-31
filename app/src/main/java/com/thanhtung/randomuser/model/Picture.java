package com.thanhtung.randomuser.model;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "picture")
public class Picture {
    @SerializedName("large")
    private String pictureLarge;

    public String getPictureLarge() {
        return pictureLarge;
    }

    public void setPictureLarge(String pictureLarge) {
        this.pictureLarge = pictureLarge;
    }
}
