package com.zimu21.zimu.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;
import com.zimu21.zimu.bean.ClassBean;
import com.zimu21.zimu.interfase.OnClickItemListener;

import java.util.List;

/**
 * Created by Administrator on 2017/3/9.
 */

public class ClassAdapter extends BaseRecycleAdapter<ClassBean> implements View.OnClickListener{
    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        mOnClickItemListener = onClickItemListener;
    }
    private OnClickItemListener mOnClickItemListener;
    private int posistion;

    public ClassAdapter(List<ClassBean> datas) {
        super(datas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        TextView mTextView=(TextView)holder.getView(R.id.name_class);
        mTextView.setText(datas.get(position).getName());
        mTextView.setOnClickListener(this);

        TextView mTextView2= (TextView)holder.getView(R.id.num_class);
        mTextView2 .setText(datas.get(position).getNum());
        mTextView.setOnClickListener(this);
        ImageView imageView = (ImageView)holder.getView(R.id.big_url_class);
        imageView.setOnClickListener(this);
       ImageView iv_teacher = (ImageView)holder.getView(R.id.teacher_icon_class);
        iv_teacher.setOnClickListener(this);
        Picasso.with(ZimuApplication.getApplication()).load(datas.get(position).getBigUrl()).error(R.mipmap.ic_launcher).into(imageView);
        Picasso.with(ZimuApplication.getApplication()).load(datas.get(position).getBigUrl()).error(R.mipmap.ic_launcher).into(iv_teacher);

    }
    @Override
    public int getLayoutId() {
        return R.layout.fragment_class_item;
    }

    @Override
    public void onClick(View v) {
        if (mOnClickItemListener != null){
            mOnClickItemListener.onClickItemListener(posistion);
        }
    }
}
