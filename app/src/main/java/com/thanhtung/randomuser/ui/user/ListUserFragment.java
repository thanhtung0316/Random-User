package com.thanhtung.randomuser.ui.user;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.thanhtung.randomuser.R;
import com.thanhtung.randomuser.base.BaseFragment;
import com.thanhtung.randomuser.databinding.FragmentUserBinding;

public class ListUserFragment extends BaseFragment<FragmentUserBinding> {

    private static ListUserFragment instance;

    public static ListUserFragment getInstance() {
        if (instance ==null){
            instance = new ListUserFragment();
        }
        return instance;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_recyclerview;
    }

    @Override
    public String getTitle() {
        return "List User";
    }
}
