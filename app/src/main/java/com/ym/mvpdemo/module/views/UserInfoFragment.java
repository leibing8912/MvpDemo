package com.ym.mvpdemo.module.views;

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
import com.ym.mvpdemo.module.presenter.FragmentPresenter;

/**
 * @className: UserInfoFragment
 * @classDescription: Ui层（IFragment）
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class UserInfoFragment extends Fragment implements UserInfoContract.IFragment {
    public final static String PAGE_INDEX = "page_index";
    private int pageindex;
    private UserInfoContract.IFragmentPresenter presenter;
    private boolean isVisibleToUser = false;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        pageindex = (int) getArguments().getSerializable(PAGE_INDEX) + 1;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        TextView fgmTv = (TextView) view.findViewById(R.id.tv_fgm);
        fgmTv.setText("第"+ pageindex + "页");
        if (isVisibleToUser) {
            new FragmentPresenter(this);
            presenter.start();
        }
        return view;
    }

    @Override
    public void showData() {
        Toast.makeText(getActivity(), "这是第" + pageindex + "个页面", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(UserInfoContract.IFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
    }
}
