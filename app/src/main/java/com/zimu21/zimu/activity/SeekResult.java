package com.zimu21.zimu.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zimu21.zimu.R;
import com.zimu21.zimu.adapter.ArticleFragmentPagerAdapter;
import com.zimu21.zimu.fragment.FragmentAppraisal;
import com.zimu21.zimu.fragment.FragmentArticle;
import com.zimu21.zimu.fragment.FragmentBooks;
import com.zimu21.zimu.fragment.FragmentClass;
import com.zimu21.zimu.fragment.FragmentFM;
import com.zimu21.zimu.fragment.FragmentRecommend;

import java.util.ArrayList;
import java.util.List;

public class SeekResult extends FragmentActivity{

    private ViewPager viewPager;
    private HorizontalScrollView scrollView;
    private LinearLayout linearLayout;
    private TextView[] titleArray = new TextView[6];
    private List<Fragment> list;
    private ArticleFragmentPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_result);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        scrollView = (HorizontalScrollView)findViewById(R.id.scrollView);
        linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
        initTab();
        initViewPager();
    }
    private void initTab() {
        String[] titles = getResources().getStringArray(R.array.arrTabTitles);
        for (int i = 0; i < titles.length; i++) {
            TextView textView = new TextView(this);
            textView.setText(" "+titles[i]);
            textView.setTextSize(16);
            textView.setTextColor(Color.BLACK);
            textView.setGravity(Gravity.CENTER);
           // textView.setBackgroundResource(R.drawable.titles);
            textView.setEnabled(true);
            textView.setTag(i);
            titleArray[i] = textView;
            titleArray[i].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    viewPager.setCurrentItem(position);
                }
            });
            linearLayout.addView(textView);
        }
        titleArray[0].setTextColor(Color.RED);
        titleArray[0].setEnabled(false);
    }

    private void initViewPager() {
        FragmentRecommend fragmentRecommend =new FragmentRecommend();
        FragmentArticle fragmentArticle =new FragmentArticle();
        FragmentAppraisal fragmentAppraisal = new FragmentAppraisal();
        FragmentClass fragmentClass = new FragmentClass();
        FragmentFM fragmentFM = new FragmentFM();
        FragmentBooks fragmentBooks = new FragmentBooks();
        //获取数据源
        list = new ArrayList<Fragment>();
        for (int i = 0; i < titleArray.length; i++) {
            list.add(fragmentRecommend );
            list.add(fragmentArticle);
            list.add(fragmentAppraisal );
            list.add(fragmentClass);
            list.add(fragmentFM);
            list.add(fragmentBooks);
        }
        //创建适配器
        adapter = new ArticleFragmentPagerAdapter(getSupportFragmentManager(), list);
        //给viewpager设置适配器
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                setCurrentTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    private void setCurrentTab(int position) {
        //处理title
        for (int i = 0; i < titleArray.length; i++) {
            titleArray[i].setTextColor(Color.BLACK);
            titleArray[i].setEnabled(true);
        }
        titleArray[position].setTextColor(Color.RED);
        titleArray[position].setEnabled(false);

        //获取屏幕的宽度
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int leftSpace = (screenWidth-titleArray[position].getWidth())/2;
        int offset = titleArray[position].getLeft()-leftSpace;
        //水平移动scrollView
        scrollView.smoothScrollTo(offset, 0);
    }

}
