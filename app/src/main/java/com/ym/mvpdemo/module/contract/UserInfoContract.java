package com.ym.mvpdemo.module.contract;

import com.ym.mvpdemo.module.model.UserInfoModel;
import com.ym.mvpdemo.module.presenter.IBasePresenter;

/**
 * @className: UserInfoContract
 * @classDescription: 契约类
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class UserInfoContract {
    /**
     * View中用于更新UI的方法集合
     * @interfaceName: IView
     * @interfaceDescription: View接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface IView extends IBaseView {
        void showLoading();//展示加载框
        void dismissLoading();//取消加载框展示
        void showUserInfo(UserInfoModel userInfoModel);//将网络请求得到的用户信息回调
        String loadUserId();//假设接口请求需要一个userId
    }

    /**
     * Frament中用于更新UI的方法集合
     * @interfaceName: IFragment
     * @interfaceDescription: Fragment接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface IFragment extends IBaseFragment {
        void showData(); // 假定显示数据
    }

    /**
     * Activity逻辑层需要使用的方法集合
     * @interfaceName: IActivityPresenter
     * @interfaceDescription: Activity逻辑层接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface IActivityPresenter extends IBasePresenter {
        void loadUserInfo();
    }

    /**
     * Fragment逻辑层需要使用的方法集合
     * @interfaceName: IFragmentPresenter
     * @interfaceDescription: Fragment逻辑层接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface IFragmentPresenter extends IBasePresenter {
        void loadData();
    }

    /**
     * 为了实现Activity UI层生命周期映射到逻辑层
     * @interfaceName: ILifeCycle
     * @interfaceDescription: 生命周期接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface ILifeCycle extends IBaseLifeCycle {
        void onRestart();
    }
}
