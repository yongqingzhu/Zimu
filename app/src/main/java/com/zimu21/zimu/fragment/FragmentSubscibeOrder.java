package com.zimu21.zimu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;
import com.zimu21.zimu.adapter.SubscibeOrderAdapter;
import com.zimu21.zimu.bean.SubscibeOrderBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */

public class FragmentSubscibeOrder extends Fragment {
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private SubscibeOrderAdapter mSubscibeOrderAdapter;
    private List<SubscibeOrderBean> mData;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscibe_order,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_order);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_order);
        data();
        initViews();
        return view;
    }
    private void initViews(){

        LinearLayoutManager manager = new LinearLayoutManager(ZimuApplication.getApplication(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mSubscibeOrderAdapter = new SubscibeOrderAdapter(mData);
        mRecyclerView.setAdapter(mSubscibeOrderAdapter);
    }
    private void data(){
        mData = new ArrayList<>();
        for (int i=0; i<50;i++){
           SubscibeOrderBean recommendBean = new SubscibeOrderBean();
            recommendBean.setTeacherName("zhangsan"+i);
            recommendBean.setTeacherContent("akljgjaldkjglkadfjl"+i);
            recommendBean.setRefeshTime("300"+i);
            recommendBean.setBabyReason("400");
            recommendBean.setTeacherIcon("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
            mData.add(recommendBean);
        }
    }

}
