package com.zimu21.zimu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;
import com.zimu21.zimu.adapter.AppraisalAdapter;
import com.zimu21.zimu.bean.AppraisalBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */

public class FragmentAppraisal extends Fragment {
    private RecyclerView mRecyclerView;
    private AppraisalAdapter mAppraisalAdapter;
    private List<AppraisalBean> mData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appraisal,null);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.appraisal);
        data();
        initViews();
        return view;

    }
    private void initViews(){
        LinearLayoutManager manager = new LinearLayoutManager(ZimuApplication.getApplication(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mAppraisalAdapter = new AppraisalAdapter(mData);
        mRecyclerView.setAdapter(mAppraisalAdapter);
    }
    private void data(){
        mData = new ArrayList<>();
        for (int i=0; i<50;i++){
            AppraisalBean recommendBean = new AppraisalBean();
            recommendBean.setName("zhangsan"+i);
            recommendBean.setContent("akljgjaldkjglkadfjl"+i);
            recommendBean.setNum("300"+i);
            recommendBean.setUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
            mData.add(recommendBean);
        }
    }
}
