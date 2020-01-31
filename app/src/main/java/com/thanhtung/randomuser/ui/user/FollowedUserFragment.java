package com.thanhtung.randomuser.ui.user;

import com.thanhtung.randomuser.R;
import com.thanhtung.randomuser.base.BaseFragment;
import com.thanhtung.randomuser.databinding.FragmentUserBinding;

public class FollowedUserFragment extends BaseFragment<FragmentUserBinding> {
    private static FollowedUserFragment instance;

    public static FollowedUserFragment getInstance() {
        if (instance == null) {
            instance = new FollowedUserFragment();
        }
        return instance;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_recyclerview;
    }

    @Override
    public String getTitle() {
        return "Followed User";
    }
}
