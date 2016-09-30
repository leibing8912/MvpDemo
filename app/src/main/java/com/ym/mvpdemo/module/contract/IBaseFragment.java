package com.ym.mvpdemo.module.contract;

/**
 * @className:IBaseFragment
 * @classDescription:Fragment接口基类
 * @author: leibing
 * @createTime: 2016/8/12
 */
public interface IBaseFragment<T> {
    // 设置逻辑
    void setPresenter(T mIFragmentPresenter);
}
