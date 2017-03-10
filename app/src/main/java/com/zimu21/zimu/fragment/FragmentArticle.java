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
import com.zimu21.zimu.adapter.ArticleAdapter;
import com.zimu21.zimu.bean.ArticleBean;
import com.zimu21.zimu.interfase.OnClickItemListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */

public class FragmentArticle extends Fragment {

    private RecyclerView mRecyclerView;
    private ArticleAdapter mAdapter;
    private List<ArticleBean> mList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_article,null);
        data();
        initViews(view);
        return view;
    }

    private void initViews(View view){
        mRecyclerView = (RecyclerView) view.findViewById(R.id.article_rv);
        LinearLayoutManager manager = new LinearLayoutManager(ZimuApplication.getApplication(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
        mAdapter = new ArticleAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickItemListener(new OnClickItemListener() {
            @Override
            public void onClickItemListener(int position) {

            }
        });
    }
    private void data(){
        mList = new ArrayList<>();
        for (int i=0; i<50;i++){
            ArticleBean  recommendBean = new ArticleBean();
            recommendBean.setName("zhangsan"+i);
            recommendBean.setContent("akljgjaldkjglkadfjl"+i);
            recommendBean.setNum("300"+i);
            recommendBean.setUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
            mList.add(recommendBean);
        }
    }
}
