package com.ym.mvpdemo.module.contract;


/**
 * @className: BaseView
 * @classDescription: view基类
 * @author: leibing
 * @createTime: 2016/8/11
 */
public interface BaseView{
    void setPresenter(UserInfoContract.ActivityPresenter presenter);
    void setLifeCycle(UserInfoContract.LifeCycle lifeCycle);
}
