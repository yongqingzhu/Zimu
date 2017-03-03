package com.zimu21.zimu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zimu21.zimu.R;
import com.zimu21.zimu.bean.ExpertSubscribe;

import java.util.List;

/**
 * Created by Administrator on 2017/3/1.
 */

public class ExpertSubscribeAdapter extends RecyclerView.Adapter<ExpertSubscribeAdapter.ViewHolder> {
    private OnClickItemListener mOnClickItemListener;
    private List<ExpertSubscribe> mData;
    private Context mContext;
    private LayoutInflater mInflater;

    public ExpertSubscribeAdapter(List<ExpertSubscribe> data, Context context) {
        mData = data;
        mContext = context;
        mInflater = mInflater.from(context);
    }


    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        mOnClickItemListener = onClickItemListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.expert_subscribe_item,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ExpertSubscribe mSubscribe = mData.get(position);
        holder.grade.setText(mSubscribe.getGrade());
        holder.mySlfe.setText(mSubscribe.getMyslfe());
        holder.addrea.setText(mSubscribe.getAddraee());
        holder.peplerMun.setText(mSubscribe.getMun());
        Picasso.with(mContext).load(mSubscribe.getIcon()).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public int position;
        private ImageView icon;
        private TextView name;
        private TextView grade;
        private TextView mySlfe;
        private TextView addrea;
        private TextView peplerMun;


        public ViewHolder(View itemView) {
            super(itemView);
          icon= (ImageView) itemView.findViewById(R.id.iv_icon);
          name= (TextView) itemView.findViewById(R.id.tv_name);
           grade= (TextView) itemView.findViewById(R.id.tv_grade);
          mySlfe= (TextView) itemView.findViewById(R.id.tv_myslef);
          addrea= (TextView) itemView.findViewById(R.id.tv_addrea);
           peplerMun= (TextView) itemView.findViewById(R.id.tv_peplerMun);
            icon.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mOnClickItemListener != null){
                mOnClickItemListener.onClickItemListener(position);
            }
        }
    }
    public interface OnClickItemListener{
        void onClickItemListener(int position);
    }

}
