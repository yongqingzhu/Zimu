package com.zimu21.zimu.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zimu21.zimu.R;
import com.zimu21.zimu.ZimuApplication;
import com.zimu21.zimu.bean.ArticleBean;
import com.zimu21.zimu.interfase.OnClickItemListener;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */

public class ArticleAdapter extends BaseRecycleAdapter<ArticleBean> implements View.OnClickListener{
    public ArticleAdapter(List<ArticleBean> datas) {
        super(datas);
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        mOnClickItemListener = onClickItemListener;
    }

    private OnClickItemListener mOnClickItemListener;
    private int posistion;
    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        TextView mTextView=(TextView)holder.getView(R.id.tv_name_article);
        mTextView.setText(datas.get(position).getName());
        mTextView.setOnClickListener(this);
        TextView mTextView1 = (TextView)holder.getView(R.id.tv_content1_article);
        mTextView1.setText(datas.get(position).getContent());
        mTextView1.setOnClickListener(this);
       TextView mTextView2= (TextView)holder.getView(R.id.tv_mun_article);
       mTextView2 .setText(datas.get(position).getNum());
        mTextView.setOnClickListener(this);
        ImageView imageView = (ImageView)holder.getView(R.id.icon_article1);
        imageView.setOnClickListener(this);
        Picasso.with(ZimuApplication.getApplication()).load(datas.get(position).getUrl()).error(R.mipmap.ic_launcher).into(imageView);
    }
    @Override
    public int getLayoutId() {
        return R.layout.article_item;
    }

    @Override
    public void onClick(View v) {
       if (mOnClickItemListener != null){
           mOnClickItemListener.onClickItemListener(posistion);
       }
    }
}
