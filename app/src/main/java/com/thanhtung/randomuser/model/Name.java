package com.thanhtung.randomuser.model;


import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "name")
public class Name {

    @SerializedName("title")
    private String title;

    @SerializedName("first")
    private String firstName;

    @SerializedName("last")
    private String lastName;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
