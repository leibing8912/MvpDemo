package com.ym.mvpdemo.module.views.userinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.ym.mvpdemo.R;
import com.ym.mvpdemo.adapter.ViewpagerAdapter;
import com.ym.mvpdemo.module.contract.ILifeCycle;
import com.ym.mvpdemo.module.contract.UserInfoContract;
import com.ym.mvpdemo.module.model.UserInfoModel;
import com.ym.mvpdemo.module.presenter.userinfo.UserInfoActivityPresenter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @className: UserInfoActivity
 * @classDescription: UI层(Activity)
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class UserInfoActivity extends AppCompatActivity implements UserInfoContract.IUserInfoActivity{
    // 切换Tab常量
    public final static int HOME_INDEX = 0;
    public final static int CZH_INDEX = 1;
    public final static int ME_INDEX = 2;
    // Activity逻辑层接口
    private UserInfoContract.IUserInfoActivityPresenter mIActivityPresenter;
    // 生命周期接口
    private ILifeCycle mILifeCycle;
    // Fragment
    private UserInfoFragment mHomeFragment;
    private UserInfoFragment mCzhFragment;
    private UserInfoFragment mMineFragment;
    // Fragement列表
    private List<Fragment> mFragmentList;
    // 标题列表
    private List<String> mTitleList;

    @BindView(R.id.tv_name) TextView nameTv;
    @BindView(R.id.tv_age) TextView ageTv;
    @BindView(R.id.tv_address) TextView addressTv;
    @BindView(R.id.vpg_main) ViewPager mainPager;
    @BindView(R.id.tv_main_home) TextView mainHomeTv;
    @BindView(R.id.tv_main_czh) TextView mainCzhTv;
    @BindView(R.id.tv_main_me) TextView mainMeTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 绑定ButterKnife
        ButterKnife.bind(this);
        // 初始化list
        initList();
        // 初始化Fragment
        initFragment();
        // 初始化逻辑
        new UserInfoActivityPresenter(this);
        mIActivityPresenter.start();
        // View映射onCreate生命周期到Presenter
        mILifeCycle.onCreate();
    }

    /**
     * 初始化列表
     * @author leibing
     * @createTime 2016/8/11
     * @lastModify 2016/8/11
     * @return
     */
    private void initList() {
        mFragmentList = new ArrayList<>();
        mTitleList = new ArrayList<>();
    }

    /**
     * 初始化Fragment
     * @author leibing
     * @createTime 2016/8/11
     * @lastModify 2016/8/11
     * @param
     * @return
     */
    private void initFragment() {
        // 首页
        mHomeFragment = new UserInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UserInfoFragment.PAGE_INDEX, HOME_INDEX);
        mHomeFragment.setArguments(bundle);
        mFragmentList.add(mHomeFragment);

        // 车智汇
        mCzhFragment = new UserInfoFragment();
        bundle = new Bundle();
        bundle.putSerializable(UserInfoFragment.PAGE_INDEX, CZH_INDEX);
        mCzhFragment.setArguments(bundle);
        mFragmentList.add(mCzhFragment);

        // 我的
        mMineFragment = new UserInfoFragment();
        bundle = new Bundle();
        bundle.putSerializable(UserInfoFragment.PAGE_INDEX, ME_INDEX);
        mMineFragment.setArguments(bundle);
        mFragmentList.add(mMineFragment);

        // ViewPager适配
        ViewpagerAdapter mAdapter = new ViewpagerAdapter(
                getSupportFragmentManager(), mFragmentList, mTitleList);
        mainPager.setAdapter(mAdapter);
        mainPager.setOffscreenPageLimit(3);
        mainPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset == 0.0)
                    switchTab(position);
            }
        });
        mainPager.setCurrentItem(0);
    }

    /**
     * 切换Tab页
     * @author leibing
     * @createTime 2016/5/6
     * @lastModify 2016/5/6
     * @param index
     * @return
     */
    private void switchTab(int index){
        switch (index){
            case HOME_INDEX:
                mainHomeTv.setTextColor(getResources().getColor(R.color.main_home_text_blue));
                mainCzhTv.setTextColor(getResources().getColor(R.color.main_home_text_gray));
                mainMeTv.setTextColor(getResources().getColor(R.color.main_home_text_gray));
                break;
            case CZH_INDEX:
                mainHomeTv.setTextColor(getResources().getColor(R.color.main_home_text_gray));
                mainCzhTv.setTextColor(getResources().getColor(R.color.main_home_text_blue));
                mainMeTv.setTextColor(getResources().getColor(R.color.main_home_text_gray));
                break;
            case ME_INDEX:
                mainHomeTv.setTextColor(getResources().getColor(R.color.main_home_text_gray));
                mainCzhTv.setTextColor(getResources().getColor(R.color.main_home_text_gray));
                mainMeTv.setTextColor(getResources().getColor(R.color.main_home_text_blue));
                break;
        }
    }

    @Override
    protected void onRestart() {
        // View映射onRestart生命周期到Presenter
        mILifeCycle.onRestart();
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // View映射onStart生命周期到Presenter
        mILifeCycle.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // View映射onResume生命周期到Presenter
        mILifeCycle.onResume();
    }

    @Override
    protected void onPause() {
        // View映射onPause生命周期到Presenter
        mILifeCycle.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        // View映射onStop生命周期到Presenter
        mILifeCycle.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // View映射onDestroy生命周期到Presenter
        mILifeCycle.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "正在加载", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissLoading() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserInfo(UserInfoModel userInfoModel) {
        if (userInfoModel != null) {
            nameTv.setText(userInfoModel.getName());
            ageTv.setText(String.valueOf(userInfoModel.getAge()));
            addressTv.setText(userInfoModel.getAddress());
        }
    }

    @Override
    public String loadUserId() {
        return "1000";//假设需要查询的用户信息的userId是1000
    }

    @Override
    public void setPresenter(UserInfoContract.IUserInfoActivityPresenter mIActivityPresenter) {
        this.mIActivityPresenter = mIActivityPresenter;
    }

    public void setILifeCycle(ILifeCycle mILifeCycle) {
        this.mILifeCycle = mILifeCycle;
    }

    @OnClick(R.id.ly_main_home) void mainOnClick() {
        mainPager.setCurrentItem(HOME_INDEX, false);
    }

    @OnClick(R.id.ly_main_czh) void czhOnClick() {
        mainPager.setCurrentItem(CZH_INDEX, false);
    }

    @OnClick(R.id.ly_main_me) void meOnClick() {
        mainPager.setCurrentItem(ME_INDEX, false);
    }
}
