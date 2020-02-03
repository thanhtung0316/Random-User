package com.thanhtung.randomuser.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.thanhtung.randomuser.model.People;

import java.util.List;

@Dao
public interface PeopleDao {
    @Query("SELECT *FROM People")
    LiveData<List<People>> getPeopleList();

    @Insert
    void insertPeople(List<People> peopleList);
}
