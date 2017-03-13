package com.zimu21.zimu.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.zimu21.zimu.BaseActivity;
import com.zimu21.zimu.R;
import com.zimu21.zimu.bean.Tab;
import com.zimu21.zimu.fragment.ClassFragment;
import com.zimu21.zimu.fragment.FindFragment;
import com.zimu21.zimu.fragment.HomeFragment;
import com.zimu21.zimu.fragment.MineFragment;
import com.zimu21.zimu.fragment.SubscibeFragment;
import com.zimu21.zimu.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */

public class ZiMuActivity extends BaseActivity {
    private FragmentTabHost mTabHost;
    private LayoutInflater mInflater;
    private ImageView img;
    private TextView text;

    private List<Tab> mTabs = new ArrayList<>(5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zimu);
        initTab();
    }

    private void initTab() {
        Tab home = new Tab(R.string.home,R.drawable.selector_icon_home,HomeFragment.class);
        Tab hot = new Tab(R.string.subscibe,R.drawable.selector_icon_hot, SubscibeFragment.class);
        Tab category = new Tab(R.string.clas,R.drawable.selector_icon_category,ClassFragment.class);
        Tab cart = new Tab(R.string.find,R.drawable.selector_icon_cart,FindFragment.class);
        Tab mine = new Tab(R.string.mine,R.drawable.selector_icon_mine,MineFragment.class);

        mTabs.add(home);
        mTabs.add(hot);
        mTabs.add(category);
        mTabs.add(cart);
        mTabs.add(mine);

        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        for (Tab tab:mTabs) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(builderIndiator(tab));
            mTabHost.addTab(tabSpec,tab.getFragment(),null);
        }

        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabHost.setCurrentTab(0);

    }

    private View builderIndiator(Tab tab){
        View view = mInflater.inflate(R.layout.tab_item_view, null);

        img = (ImageView) view.findViewById(R.id.icon_tab);
        text = (TextView) view.findViewById(R.id.text_indicator);
        img.setBackgroundResource(tab.getImage());
        text.setText(tab.getTitle());

        return view;
    }

}
