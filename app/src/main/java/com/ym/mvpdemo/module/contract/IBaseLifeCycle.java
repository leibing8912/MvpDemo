package com.ym.mvpdemo.module.contract;

/**
 * @className: IBaseLifeCycle
 * @classDescription: 生命周期接口基类
 * @author: leibing
 * @createTime: 2016/8/11
 */
public interface IBaseLifeCycle {
    void onCreate();
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
}
