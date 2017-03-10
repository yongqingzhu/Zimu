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
import com.zimu21.zimu.adapter.RecommendAdapter;
import com.zimu21.zimu.bean.RecommendBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */

public class FragmentRecommend extends Fragment{
    private RecyclerView mRecyclerView;
    private RecommendAdapter mAdapter;
    private List<RecommendBean> mList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recommend,null);
        data();
        initViews(view);
        return view;
    }

    private void initViews(View view){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recommend_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(ZimuApplication.getApplication(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new RecommendAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setHeaderView(LayoutInflater.from(ZimuApplication.getApplication()).inflate(R.layout.recommend_header,null,false));

    }
    private void data(){
        mList = new ArrayList<>();
        for (int i=0; i<50;i++){
            RecommendBean  recommendBean = new RecommendBean();
            recommendBean.setName("zhangsan"+i);
            recommendBean.setContent("akljgjaldkjglkadfjl"+i);
            recommendBean.setReadMun("300"+i);
            recommendBean.setReplyMun("400"+1);
            recommendBean.setComment("dimin");
            mList.add(recommendBean);
        }
    }
}
