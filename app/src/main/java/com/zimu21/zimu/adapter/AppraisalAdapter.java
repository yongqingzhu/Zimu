package com.zimu21.zimu.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;
import com.zimu21.zimu.bean.AppraisalBean;
import com.zimu21.zimu.interfase.OnClickItemListener;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */

public class AppraisalAdapter extends BaseRecycleAdapter<AppraisalBean>  implements View.OnClickListener{
    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        mOnClickItemListener = onClickItemListener;
    }
    private OnClickItemListener mOnClickItemListener;
    private int posistion;

    public AppraisalAdapter(List<AppraisalBean> datas) {
        super(datas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        TextView tv_Name= (TextView)holder.getView(R.id.tv_name_article);
        tv_Name .setText(datas.get(position).getName());
        tv_Name.setOnClickListener(this);
        TextView tv_content= (TextView)holder.getView(R.id.tv_content1_article);
        tv_content.setText(datas.get(position).getContent());
        tv_content.setOnClickListener(this);
        TextView tv_Mun= (TextView)holder.getView(R.id.tv_mun_article);
        tv_Mun.setText(datas.get(position).getName());
        tv_Mun.setOnClickListener(this);
        ImageView icon = (ImageView)holder.getView(R.id.icon_article1);
        icon.setOnClickListener(this);
        Picasso.with(ZimuApplication.getApplication()).load(datas.get(position).getUrl()).error(R.mipmap.ic_launcher).into(icon);
    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_appraisal_item;
    }
    @Override
    public void onClick(View v) {
        if (mOnClickItemListener !=null){
            mOnClickItemListener.onClickItemListener(posistion);
        }
    }
}
