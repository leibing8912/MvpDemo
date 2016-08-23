package com.ym.mvpdemo.module.presenter;

import android.os.Handler;
import com.ym.mvpdemo.module.contract.UserInfoContract;
import com.ym.mvpdemo.module.model.UserInfoModel;

/**
 * @className: LifeCycleActivityPresenter
 * @classDescription: 逻辑层(Activity)
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class LifeCycleActivityPresenter implements UserInfoContract.IActivityPresenter, UserInfoContract.ILifeCycle {

    private UserInfoContract.IView mIView;

    public LifeCycleActivityPresenter(UserInfoContract.IView mIView) {
        this.mIView = mIView;
        mIView.setPresenter(this);
        mIView.setILifeCycle(this);
    }

    @Override
    public void loadUserInfo() {
        String userId = mIView.loadUserId();
        mIView.showLoading();//接口请求前显示loading
        //这里模拟接口请求回调-
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //模拟接口返回的json，并转换为javaBean
                UserInfoModel userInfoModel = new UserInfoModel("小宝", 1, "杭州");
                mIView.showUserInfo(userInfoModel);
                mIView.dismissLoading();
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
