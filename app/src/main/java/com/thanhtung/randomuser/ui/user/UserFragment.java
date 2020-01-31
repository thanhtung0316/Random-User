package com.thanhtung.randomuser.ui.user;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.thanhtung.randomuser.R;
import com.thanhtung.randomuser.adapter.ViewPagerAdapter;
import com.thanhtung.randomuser.base.BaseFragment;
import com.thanhtung.randomuser.databinding.FragmentUserBinding;

public class UserFragment extends BaseFragment<FragmentUserBinding> {
    private static UserFragment instance;
    private ViewPagerAdapter pagerAdapter;
    public static UserFragment getInstance() {
        if (instance==null){
            instance = new UserFragment();
        }
        return instance;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),0,ListUserFragment
                .getInstance(),SavedUserFragment.getInstance(),FollowedUserFragment.getInstance());
        binding.viewPager.setAdapter(pagerAdapter);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    public String getTitle() {
        return "User";
    }
}
