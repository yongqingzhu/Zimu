package com.zimu21.zimu.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;
import com.zimu21.zimu.bean.SubscibeOrderBean;
import com.zimu21.zimu.interfase.OnClickItemListener;

import java.util.List;

/**
 * Created by Administrator on 2017/3/11.
 */

public class SubscibeOrderAdapter extends BaseRecycleAdapter<SubscibeOrderBean> implements View.OnClickListener{
    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        mOnClickItemListener = onClickItemListener;
    }
    private OnClickItemListener mOnClickItemListener;
    private int posistion;


    public SubscibeOrderAdapter(List<SubscibeOrderBean> datas) {
        super(datas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        TextView name = (TextView) holder.getView(R.id.teacher_name);
        TextView content = (TextView) holder.getView(R.id.teacher_content);
        TextView time = (TextView) holder.getView(R.id.refesh_time);
        TextView reason = (TextView) holder.getView(R.id.baby_reason);
        name.setText(datas.get(position).getTeacherName());
        content.setText(datas.get(position).getTeacherContent());
        time.setText(datas.get(position).getRefeshTime());
        reason.setText(datas.get(position).getBabyReason());
        ImageView icon = (ImageView) holder.getView(R.id.teacher_iamgeview);
        icon.setOnClickListener(this);
        name.setOnClickListener(this);
        content.setOnClickListener(this);
        time.setOnClickListener(this);
        reason.setOnClickListener(this);
        Picasso.with(ZimuApplication.getApplication()).load(datas.get(position).getTeacherIcon()).error(R.mipmap.ic_launcher).into(icon);

    }

    @Override
    public int getLayoutId() {
        return R.layout.subscibe_order_item;
    }

    @Override
    public void onClick(View v) {
        if (mOnClickItemListener != null){
            mOnClickItemListener.onClickItemListener(posistion);
        }
    }
}
