package com.thanhtung.randomuser.request;

import com.google.gson.annotations.SerializedName;
import com.thanhtung.randomuser.model.People;

import java.util.List;

public class PeopleResponse {

    @SerializedName("results")
    private List<People> peopleList;

    public List<People> getPeopleList() {
        return peopleList;
    }
}
