package com.thanhtung.randomuser.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.thanhtung.randomuser.repository.UserRepository;

public class UserViewModel extends AndroidViewModel {

    private UserRepository repository;


    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = UserRepository.getInstance(application);
        init();
    }

    private void init() {
    }


}
