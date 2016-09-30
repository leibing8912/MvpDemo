package com.ym.mvpdemo.module.contract;

/**
 * @className: ILifeCycle
 * @classDescription: 生命周期接口（为了实现Activity UI层生命周期映射到逻辑层）
 * @author: leibing
 * @createTime: 2016/8/11
 */
public interface ILifeCycle {
    void onCreate();
    void onRestart();
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
}
