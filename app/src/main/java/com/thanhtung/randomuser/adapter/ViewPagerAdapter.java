package com.thanhtung.randomuser.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.thanhtung.randomuser.base.BaseFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private BaseFragment[] fms;
    private Fragment mCurrentFragment;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, BaseFragment... fms) {
        super(fm, behavior);
        this.fms = fms;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fms[position];
    }

    public Fragment getCurrentFragment(){
        return mCurrentFragment;
    }
    @Override
    public int getCount() {
        return fms == null ? 0 : fms.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fms[position].getTitle();
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if (getCurrentFragment()!=object){
            mCurrentFragment = (Fragment) object;
        }
        super.setPrimaryItem(container, position, object);
    }

}
