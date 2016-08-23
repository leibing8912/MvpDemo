package com.ym.mvpdemo.module.presenter;

import com.ym.mvpdemo.module.contract.UserInfoContract;

/**
 * @className:FragmentPresenter
 * @classDescription:逻辑层(Fragment)
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class FragmentPresenter implements UserInfoContract.IFragmentPresenter {
    // Fragment接口
    private UserInfoContract.IFragment mIFragment;

    /**
     * 构造函数
     * @author leibing
     * @createTime 2016/08/23
     * @lastModify 2016/08/23
     * @param mIFragment Fragment接口
     * @return
     */
    public FragmentPresenter(UserInfoContract.IFragment mIFragment) {
        this.mIFragment = mIFragment;
        mIFragment.setPresenter(this);
    }

    @Override
    public void loadData() {
        System.out.println("ddddddddddddddddddd mIFragment loadData");
        mIFragment.showData();
    }

    @Override
    public void start() {
        System.out.println("ddddddddddddddddddd mIFragment start");
        loadData();
    }
}
