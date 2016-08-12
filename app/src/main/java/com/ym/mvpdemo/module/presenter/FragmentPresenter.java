package com.ym.mvpdemo.module.presenter;

import com.ym.mvpdemo.module.contract.UserInfoContract;

/**
 * @className:FragmentPresenter
 * @classDescription:逻辑层(Fragment)
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class FragmentPresenter implements UserInfoContract.FragmentPresenter{

    private UserInfoContract.Fragment fragment;

    public FragmentPresenter(UserInfoContract.Fragment fragment) {
        this.fragment = fragment;
        fragment.setPresenter(this);
    }

    @Override
    public void loadData() {
        System.out.println("ddddddddddddddddddd fragment loadData");
        fragment.showData();
    }

    @Override
    public void start() {
        System.out.println("ddddddddddddddddddd fragment start");
        loadData();
    }
}
