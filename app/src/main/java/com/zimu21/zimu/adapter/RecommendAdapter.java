package com.zimu21.zimu.adapter;

import android.widget.TextView;

import com.zimu21.zimu.R;
import com.zimu21.zimu.bean.RecommendBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/8.
 */

public class RecommendAdapter extends BaseRecycleAdapter<RecommendBean>{

    public RecommendAdapter(List<RecommendBean> datas) {
        super(datas);
    }

    @Override
    protected void bindData(BaseViewHolder holder, int position) {
        ((TextView)holder.getView(R.id.title_name)).setText(datas.get(position).getName());
        ((TextView)holder.getView(R.id.content_tv)).setText(datas.get(position).getContent());
        ((TextView)holder.getView(R.id.read_mun)).setText(datas.get(position).getReadMun());
        ((TextView)holder.getView(R.id.reply_mun)).setText(datas.get(position).getReplyMun());
        ((TextView)holder.getView(R.id.comment)).setText(datas.get(position).getComment());


    }

    @Override
    public int getLayoutId() {

        return R.layout.recommend_item;
    }
}
