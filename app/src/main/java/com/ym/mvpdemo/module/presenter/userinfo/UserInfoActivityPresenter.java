package com.ym.mvpdemo.module.presenter.userinfo;

import android.os.Handler;
import com.ym.mvpdemo.module.contract.IActivityLifeCycle;
import com.ym.mvpdemo.module.contract.UserInfoContract;
import com.ym.mvpdemo.module.model.UserInfoModel;

/**
 * @className: UserInfoActivityPresenter
 * @classDescription: 用户信息activity逻辑层
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class UserInfoActivityPresenter implements UserInfoContract.IUserInfoActivityPresenter, IActivityLifeCycle {
    // 用户信息activity接口
    private UserInfoContract.IUserInfoActivity mIUserInfoActivity;

    /**
     * 构造函数
     * @author leibing
     * @createTime 2016/08/23
     * @lastModify 2016/08/23
     * @param mIUserInfoActivity 用户信息activity接口
     * @return
     */
    public UserInfoActivityPresenter(UserInfoContract.IUserInfoActivity mIUserInfoActivity) {
        this.mIUserInfoActivity = mIUserInfoActivity;
        // 设置逻辑
        mIUserInfoActivity.setPresenter(this);
        // 设置生命周期
        mIUserInfoActivity.setILifeCycle(this);
    }

    @Override
    public void loadUserInfo() {
        String userId = mIUserInfoActivity.loadUserId();
        System.out.println("ddddddddddddddddddddddddddd userId = " + userId);
        mIUserInfoActivity.showLoading();//接口请求前显示loading
        //这里模拟接口请求回调-
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟接口返回的json，并转换为javaBean
                UserInfoModel userInfoModel = new UserInfoModel("小宝", 1, "杭州");
                mIUserInfoActivity.showUserInfo(userInfoModel);
                mIUserInfoActivity.dismissLoading();
            }
        }, 3000);
    }

    @Override
    public void start() {
        loadUserInfo();
    }

    @Override
    public void onRestart() {
        System.out.println("ddddddddddddddddddddd present onRestart");
    }

    @Override
    public void onCreate() {
        System.out.println("ddddddddddddddddddddd present onCreate");
    }

    @Override
    public void onStart() {
        System.out.println("ddddddddddddddddddddd present onStart");
    }

    @Override
    public void onResume() {
        System.out.println("ddddddddddddddddddddd present onResume");
    }

    @Override
    public void onPause() {
        System.out.println("ddddddddddddddddddddd present onPause");
    }

    @Override
    public void onStop() {
        System.out.println("ddddddddddddddddddddd present onStop");
    }

    @Override
    public void onDestroy() {
        System.out.println("ddddddddddddddddddddd present onDestroy");
    }
}
