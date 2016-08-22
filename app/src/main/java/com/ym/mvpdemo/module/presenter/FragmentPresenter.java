package com.ym.mvpdemo.module.presenter;

import com.ym.mvpdemo.module.contract.UserInfoContract;

/**
 * @className:FragmentPresenter
 * @classDescription:逻辑层(Fragment)
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class FragmentPresenter implements UserInfoContract.IFragmentPresenter {

    private UserInfoContract.IFragment IFragment;

    public FragmentPresenter(UserInfoContract.IFragment IFragment) {
        this.IFragment = IFragment;
        IFragment.setPresenter(this);
    }

    @Override
    public void loadData() {
        System.out.println("ddddddddddddddddddd IFragment loadData");
        IFragment.showData();
    }

    @Override
    public void start() {
        System.out.println("ddddddddddddddddddd IFragment start");
        loadData();
    }
}
