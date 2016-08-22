package com.ym.mvpdemo.module.contract;


/**
 * @className: IBaseView
 * @classDescription: view接口基类
 * @author: leibing
 * @createTime: 2016/8/11
 */
public interface IBaseView {
    void setPresenter(UserInfoContract.IActivityPresenter presenter);
    void setILifeCycle(UserInfoContract.ILifeCycle ILifeCycle);
}
