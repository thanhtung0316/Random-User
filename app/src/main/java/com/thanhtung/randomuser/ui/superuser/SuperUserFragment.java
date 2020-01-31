package com.thanhtung.randomuser.ui.superuser;

import com.thanhtung.randomuser.R;
import com.thanhtung.randomuser.base.BaseFragment;
import com.thanhtung.randomuser.databinding.FragmentUserBinding;

public class SuperUserFragment extends BaseFragment<FragmentUserBinding> {

    private static SuperUserFragment instance;

    public static SuperUserFragment getInstance() {
        if (instance == null){
            instance = new SuperUserFragment();
        }
        return instance;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_super_user;
    }

    @Override
    public String getTitle() {
        return "Super User";
    }
}
