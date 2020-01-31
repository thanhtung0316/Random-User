package com.thanhtung.randomuser.request;

import androidx.lifecycle.LiveData;

import retrofit2.http.Query;


public interface Api {
    LiveData<ApiResponse<PeopleResponse>> getPeople(
            @Query("results") int numberOfResults,
            @Query("nat") String language
            );
}
