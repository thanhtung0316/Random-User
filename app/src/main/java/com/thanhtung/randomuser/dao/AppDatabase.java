package com.thanhtung.randomuser.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.thanhtung.randomuser.model.People;

@Database(entities = People.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;
    private static String DATABASE_NAME = "user-database";


    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract PeopleDao getPeopleDao();
}
