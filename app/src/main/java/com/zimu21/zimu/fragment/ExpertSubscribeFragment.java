package com.zimu21.zimu.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.zimu21.zimu.R;
import com.zimu21.zimu.adapter.ExpertSubscribeAdapter;
import com.zimu21.zimu.bean.ExpertSubscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/28.
 */

public class ExpertSubscribeFragment extends Fragment implements View.OnClickListener{

    private RadioButton rbBank;
    private RadioButton rbRange;
    private RadioButton rbMoney;
    private RadioButton rbTime;
    private ImageView arrow1;
    private ImageView arrow2;
    private ImageView arrow3;
    private ImageView arrow4;
    private RecyclerView mRecyclerView;
    private List<ExpertSubscribe> mList;
    private ExpertSubscribeAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expert_subscribe,null);
        initViews(view);
        initLinster();
        initTit();
        initData();
        initRecycler();

        return view;
    }
    public void initRecycler(){
        mAdapter = new ExpertSubscribeAdapter(mList,getContext());
        // 设置LinearLayoutManager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        // 设置ItemAnimator
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // 设置固定大小
        mRecyclerView.setHasFixedSize(true);


        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnClickItemListener(new ExpertSubscribeAdapter.OnClickItemListener() {
            @Override
            public void onClickItemListener(int position) {


            }
        });


    }
    public void initData(){
        String url ="https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
        mList = new ArrayList<>();
        for (int i=0; i<50; i++){
            ExpertSubscribe subscribe = new ExpertSubscribe(url,"zhasng"+i,"bbb"+i,"aaaa"+i,"ccc"+i,"dddd"+i);

        mList.add(subscribe);


        }

    }



    public void initViews(View view) {
        rbBank = (RadioButton)view.findViewById(R.id.rb_locale);
        rbMoney = (RadioButton) view.findViewById(R.id.rb_price);
        rbRange = (RadioButton) view.findViewById(R.id.rb_field);
        rbTime = (RadioButton) view.findViewById(R.id.rb_more);
        arrow1 = (ImageView) view.findViewById(R.id.arrow1);
        arrow2 = (ImageView) view.findViewById(R.id.arrow2);
        arrow3 = (ImageView) view.findViewById(R.id.arrow3);
        arrow4 = (ImageView) view.findViewById(R.id.arrow4);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.lv_expert);

    }
    private void initLinster(){
        rbMoney.setOnClickListener(this);
        rbTime.setOnClickListener(this);
        rbRange.setOnClickListener(this);
        rbBank.setOnClickListener(this);

    }

    private void initTit() {
        rbBank.setText("杭州");
        rbRange.setText("领域");
        rbMoney.setText("价格");
        rbTime.setText("更多");
    }
    public void clearTextColor(){
        rbTime.setTextColor(getResources().getColor(R.color.black));
        rbMoney.setTextColor(getResources().getColor(R.color.black));
        rbRange.setTextColor(getResources().getColor(R.color.black));
        rbBank.setTextColor(getResources().getColor(R.color.black));
    }
    public void clearArrow(){
        arrow1.setImageResource(R.mipmap.down_arrow);
        arrow2.setImageResource(R.mipmap.down_arrow);
        arrow3.setImageResource(R.mipmap.down_arrow);
        arrow4.setImageResource(R.mipmap.down_arrow);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rb_locale:
                clearArrow();
                clearTextColor();
                rbBank.setTextColor(getResources().getColor(R.color.tv_money_color));
                arrow1.setImageResource(R.mipmap.up_arrow);
             /*  Intent localeIntent = new Intent(ExpertSubscribeActivity.this,City_Orientation_Activity.class);
                startActivity(localeIntent);*/

                break;
            case R.id.rb_price:
                clearArrow();
                clearTextColor();
                rbMoney.setTextColor(getResources().getColor(R.color.tv_money_color));
                arrow3.setImageResource(R.mipmap.up_arrow);
                //sbp.reOpen();
                break;
            case R.id.rb_field:
                clearArrow();
                clearTextColor();
                rbRange.setTextColor(getResources().getColor(R.color.tv_money_color));
                arrow2.setImageResource(R.mipmap.up_arrow);
                // sbp.reOpen();
                break;
            case R.id.rb_more:
                clearArrow();
                clearTextColor();
                rbTime.setTextColor(getResources().getColor(R.color.tv_money_color));
                arrow4.setImageResource(R.mipmap.up_arrow);
                //sbp.reOpen();
                break;
            default:
                break;
        }
    }
}
