package com.thanhtung.randomuser.request;


import com.thanhtung.randomuser.utils.LiveDataCallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ApiBuilder {
    private static Api api;

    public static Api getInstance(){
        if (api == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.randomuser.me")
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            api = retrofit.create(Api.class);
        }
        return api;
    }

}
