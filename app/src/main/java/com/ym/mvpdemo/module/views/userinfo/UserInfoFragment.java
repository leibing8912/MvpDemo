package com.ym.mvpdemo.module.views.userinfo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ym.mvpdemo.R;
import com.ym.mvpdemo.module.contract.UserInfoContract;
import com.ym.mvpdemo.module.presenter.userinfo.UserInfoFragmentPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @className: UserInfoFragment
 * @classDescription: Ui层（IFragment）
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class UserInfoFragment extends Fragment implements UserInfoContract.IUserInfoFragment {
    // 页面常量
    public final static String PAGE_INDEX = "page_index";
    // 页面数字
    private int pageIndex;
    // UI回调
    private UserInfoContract.IUserInfoFragmentPresenter mIFragmentPresenter;
    // 判断是否当前Fragment
    private boolean isVisibleToUser = false;

    @BindView(R.id.tv_fgm)
    TextView fgmTv;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        pageIndex = (int) getArguments().getSerializable(PAGE_INDEX) + 1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        // 绑定ButterKnife
        ButterKnife.bind(this, view);

        fgmTv.setText("第"+ pageIndex + "页");
        if (isVisibleToUser) {
            new UserInfoFragmentPresenter(this);
            mIFragmentPresenter.start();
        }
        return view;
    }

    @Override
    public void showData() {
        Toast.makeText(getActivity(), "这是第" + pageIndex + "个页面", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(UserInfoContract.IUserInfoFragmentPresenter mIFragmentPresenter) {
        this.mIFragmentPresenter = mIFragmentPresenter;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
    }
}
