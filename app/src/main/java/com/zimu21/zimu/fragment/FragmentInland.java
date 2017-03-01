package com.zimu21.zimu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.zimu21.zimu.Data;
import com.zimu21.zimu.R;
import com.zimu21.zimu.adapter.CitiesAdapter;
import com.zimu21.zimu.bean.CitiesBean;
import com.zimu21.zimu.view.QuickIndexView;

import java.util.List;

/**
 * Created by Administrator on 2017/2/27.
 */

public class FragmentInland extends Fragment {
    private QuickIndexView quickIndexView;
    private RecyclerView recyclerView;
    private CitiesAdapter adapter;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext =(Activity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inland,null);
        initView(view);
        initEvent();
        return view;
    }

    private void initView(View view) {
        quickIndexView = (QuickIndexView)view. findViewById(R.id.quickIndexView);

        recyclerView = (RecyclerView)view. findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Gson gson = new Gson();
        CitiesBean citiesBean = gson.fromJson(Data.citiesJson, CitiesBean.class);
        adapter = new CitiesAdapter(mContext,citiesBean.getDatas());
        recyclerView.setAdapter(adapter);
    }

    private void initEvent() {
        quickIndexView.setOnIndexChangeListener(new QuickIndexView.OnIndexChangeListener() {
            @Override
            public void onIndexChange(String words) {
                if(words.equals("当") || words.equals("热")){
                    LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                            .getLayoutManager();
                    llm.scrollToPositionWithOffset(0, 0);
                    return;
                }
                List<CitiesBean.DatasBean> datas = adapter.getData();
                if(datas!=null && datas.size()>0) {
                    int count = 0;
                    for (int i = 0; i < datas.size(); i++) {
                        CitiesBean.DatasBean datasBean = datas.get(i);
                        if(datasBean.getAlifName().equals(words)){
                            LinearLayoutManager llm = (LinearLayoutManager) recyclerView
                                    .getLayoutManager();
                            llm.scrollToPositionWithOffset(count+1, 0);
                            return;
                        }
                        count+=datasBean.getAddressList().size()+1;
                    }
                }
            }
        });
    }



}
