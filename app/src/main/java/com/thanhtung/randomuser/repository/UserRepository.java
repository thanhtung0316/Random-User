package com.thanhtung.randomuser.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.thanhtung.randomuser.dao.AppDatabase;
import com.thanhtung.randomuser.dao.PeopleDao;
import com.thanhtung.randomuser.model.People;
import com.thanhtung.randomuser.request.ApiBuilder;
import com.thanhtung.randomuser.request.ApiResponse;
import com.thanhtung.randomuser.request.PeopleResponse;
import com.thanhtung.randomuser.utils.AppExecutors;
import com.thanhtung.randomuser.utils.NetworkBoundResource;
import com.thanhtung.randomuser.utils.Resource;

import java.util.List;

public class UserRepository {
    private static UserRepository instance;
    private PeopleDao peopleDao;


    public static UserRepository getInstance(Context context) {
        if (instance ==null){
            instance = new UserRepository(context);
        }
        return instance;
    }

    public UserRepository(Context context) {
        peopleDao = AppDatabase.getInstance(context).getPeopleDao();
    }

    public LiveData<Resource<List<People>>> getPeopleApi(){
        return new NetworkBoundResource<List<People>, PeopleResponse>(AppExecutors.getInstance()) {
            @Override
            protected void saveCallResult(PeopleResponse item) {
                peopleDao.insertPeople(item.getPeopleList());
            }

            @Override
            protected LiveData<ApiResponse<PeopleResponse>> createCall() {
                return ApiBuilder.getInstance().getPeople(10,"en");
            }

            @Override
            protected boolean shouldFetch(List<People> peopleList) {
                return true;
            }

            @Override
            protected LiveData<List<People>> loadFromDb() {
                return peopleDao.getPeopleList();
            }
        }.getAsLiveData();
    }
}
