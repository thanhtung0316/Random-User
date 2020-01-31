package com.thanhtung.randomuser.ui.user;

import com.thanhtung.randomuser.R;
import com.thanhtung.randomuser.base.BaseFragment;
import com.thanhtung.randomuser.databinding.FragmentUserBinding;

public class SavedUserFragment extends BaseFragment<FragmentUserBinding> {
    private static SavedUserFragment instance;

    public static SavedUserFragment getInstance() {
        if (instance ==null){
            instance = new SavedUserFragment();
        }
        return instance;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_recyclerview;
    }

    @Override
    public String getTitle() {
        return "Saved User";
    }
}
