package com.ym.mvpdemo.module.contract;

import com.ym.mvpdemo.module.model.UserInfoModel;

/**
 * @className: UserInfoContract
 * @classDescription: 用户信息契约类
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class UserInfoContract {
    /**
     * 用户信息activity中用于更新UI的方法集合
     * @interfaceName: IUserInfoActivity
     * @interfaceDescription: View接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface IUserInfoActivity extends IBaseActivity<IUserInfoActivityPresenter> {
        void showLoading();//展示加载框
        void dismissLoading();//取消加载框展示
        void showUserInfo(UserInfoModel userInfoModel);//将网络请求得到的用户信息回调
        String loadUserId();//假设接口请求需要一个userId
    }

    /**
     * 用户信息Fragment中用于更新UI的方法集合
     * @interfaceName: IFragment
     * @interfaceDescription: Fragment接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface IUserInfoFragment extends IBaseFragment<IUserInfoFragmentPresenter> {
        void showData(); // 假定显示数据
    }

    /**
     * 用户信息activity逻辑层需要使用的方法集合
     * @interfaceName: IUserInfoActivityPresenter
     * @interfaceDescription: 用户信息Activity逻辑层接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface IUserInfoActivityPresenter extends IBasePresenter {
        void loadUserInfo();
    }

    /**
     * 用户信息Fragment逻辑层需要使用的方法集合
     * @interfaceName: IUserInfoFragmentPresenter
     * @interfaceDescription: 用户信息Fragment逻辑层接口
     * @author: leibing
     * @createTime: 2016/08/23
     */
    public interface IUserInfoFragmentPresenter extends IBasePresenter {
        void loadData();
    }
}
