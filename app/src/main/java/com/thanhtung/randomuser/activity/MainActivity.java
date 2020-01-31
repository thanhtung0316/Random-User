package com.thanhtung.randomuser.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.thanhtung.randomuser.R;
import com.thanhtung.randomuser.base.BaseActivity;
import com.thanhtung.randomuser.databinding.ActivityMainBinding;
import com.thanhtung.randomuser.ui.superuser.SuperUserFragment;
import com.thanhtung.randomuser.ui.user.UserFragment;

public class MainActivity extends BaseActivity<ActivityMainBinding> implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Fragment selectedFragment;
    private static final String TAG = "MainActivity";


    @Override
    protected void initAct(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "initAct: ");
        binding.botNav.setOnNavigationItemSelectedListener(this);
        if (savedInstanceState==null){
            binding.botNav.setSelectedItemId(R.id.nav_user);
        }
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (menuItem.getItemId()) {
            case R.id.nav_user:
                selectedFragment = UserFragment.getInstance();
                break;
            case R.id.nav_super_user:
                selectedFragment = SuperUserFragment.getInstance();
                break;
        }
        if (!selectedFragment.isAdded()){
            transaction.add(R.id.ly_frame,selectedFragment,selectedFragment.getClass().getSimpleName());
        }
        Log.e(TAG, "onNavigationItemSelected: "+selectedFragment.getClass().getSimpleName());
        showFragment(selectedFragment);
        transaction.commit();
        return true;
    }

    private void showFragment(Fragment fmShow) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (int i = 0; i <getSupportFragmentManager().getFragments().size() ; i++) {
            transaction.hide(getSupportFragmentManager().getFragments().get(i));
        }
        transaction.show(fmShow);
        transaction.commit();
    }
}
