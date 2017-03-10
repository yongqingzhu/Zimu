package com.zimu21.zimu.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */

public class ArticleFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragList = null;

    public ArticleFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragList) {
        super(fm);
        this.fragList = fragList;
    }
    @Override
    public Fragment getItem(int position) {


        return fragList.get(position);
    }

    @Override
    public int getCount() {
        return fragList.size();
    }
}
