package com.ym.mvpdemo.module.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.ym.mvpdemo.R;
import com.ym.mvpdemo.adapter.ViewpagerAdapter;
import com.ym.mvpdemo.module.contract.UserInfoContract;
import com.ym.mvpdemo.module.model.UserInfoModel;
import com.ym.mvpdemo.module.presenter.LifeCycleActivityPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: UserInfoActivity
 * @classDescription: UI层(Activity)
 * @author: leibing
 * @createTime: 2016/8/11
 */
public class UserInfoActivity extends AppCompatActivity implements UserInfoContract.IView, View.OnClickListener{
    private TextView tv_name;
    private TextView tv_age;
    private TextView tv_address;
    private ViewPager mainPager;
    private TextView mainHomeTv;
    private TextView mainCzhTv;
    private TextView mainMeTv;
    private UserInfoContract.IActivityPresenter presenter;
    private UserInfoContract.ILifeCycle ILifeCycle;
    private UserInfoFragment mHomeFragment;
    private UserInfoFragment mCzhFragment;
    private UserInfoFragment mMineFragment;
    private List<Fragment> mFragmentList;
    private List<String> mTitleList;
    public final static int HOME_INDEX = 0;
    public final static int CZH_INDEX = 1;
    public final static int ME_INDEX = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_age = (TextView) findViewById(R.id.tv_age);
        tv_address = (TextView) findViewById(R.id.tv_address);
        mainPager = (ViewPager) findViewById(R.id.vpg_main);
        mainHomeTv = (TextView) findViewById(R.id.tv_main_home);
        mainCzhTv = (TextView) findViewById(R.id.tv_main_czh);
        mainMeTv  = (TextView) findViewById(R.id.tv_main_me);

        initList();

        initFragment();

        findViewById(R.id.ly_main_home).setOnClickListener(this);
        findViewById(R.id.ly_main_czh).setOnClickListener(this);
        findViewById(R.id.ly_main_me).setOnClickListener(this);

        new LifeCycleActivityPresenter(this);
        presenter.start();
        // View映射onCreate生命周期到Presenter
        ILifeCycle.onCreate();
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
        ILifeCycle.onRestart();
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // View映射onStart生命周期到Presenter
        ILifeCycle.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // View映射onResume生命周期到Presenter
        ILifeCycle.onResume();
    }

    @Override
    protected void onPause() {
        // View映射onPause生命周期到Presenter
        ILifeCycle.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        // View映射onStop生命周期到Presenter
        ILifeCycle.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // View映射onDestroy生命周期到Presenter
        ILifeCycle.onDestroy();
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
            tv_name.setText(userInfoModel.getName());
            tv_age.setText(String.valueOf(userInfoModel.getAge()));
            tv_address.setText(userInfoModel.getAddress());
        }
    }

    @Override
    public String loadUserId() {
        return "1000";//假设需要查询的用户信息的userId是1000
    }

    @Override
    public void setPresenter(UserInfoContract.IActivityPresenter presenter) {
        this.presenter = presenter;
    }

    public void setILifeCycle(UserInfoContract.ILifeCycle ILifeCycle) {
        this.ILifeCycle = ILifeCycle;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ly_main_home:
                mainPager.setCurrentItem(HOME_INDEX, false);
                break;
            case R.id.ly_main_czh:
                mainPager.setCurrentItem(CZH_INDEX, false);
                break;
            case R.id.ly_main_me:
                mainPager.setCurrentItem(ME_INDEX, false);
                break;
            default:
                break;
        }
    }
}
