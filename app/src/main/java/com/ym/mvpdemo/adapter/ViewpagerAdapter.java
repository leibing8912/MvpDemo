package com.ym.mvpdemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/**
 * @className : ViewpagerAdapter
 * @classDescription : ViewPager适配类
 * @author : leibing
 * @createTime : 2016/8/11
 *
 */
public class ViewpagerAdapter extends FragmentPagerAdapter {
    // Fragment列表
    private List<Fragment> mFragmentList;
    // 标题列表
    private List<String> mTitleList;

    /**
     *
     * @author leibing
     * @createTime 2016/08/23
     * @lastModify 2016/08/23
     * @param fm Fragment管理器
     * @param mFragmentList Frament列表
     * @param mTitleList 标题列表
     * @return
     */
    public ViewpagerAdapter(FragmentManager fm, List<Fragment> mFragmentList, List<String> mTitleList){
         super(fm);
        this.mFragmentList = mFragmentList;
        this.mTitleList = mTitleList;
    }

    /**
     * 得到每个页面
     * @author leibing
     * @createTime 2016/08/23
     * @lastModify 2016/08/23
     * @param arg0
     * @return Fragment
     */
    @Override
    public Fragment getItem(int arg0) {
        return (mFragmentList == null || mFragmentList.size() == 0) ? null
                : mFragmentList.get(arg0);
    }

    /**
     * 每个页面的title
     * @author leibing
     * @createTime 2016/08/23
     * @lastModify 2016/08/23
     * @param position 页面数
     * @return CharSequence
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return (mTitleList.size() > position) ? mTitleList.get(position) : "";
    }

    /**
     * 获取页面的数量
     * @author leibing
     * @createTime 2016/08/23
     * @lastModify 2016/08/23
     * @param
     * @return int
     */
    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }
}