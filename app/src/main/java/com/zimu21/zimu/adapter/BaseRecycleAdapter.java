package com.zimu21.zimu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/8.
 */

public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseRecycleAdapter.BaseViewHolder> {

    protected List<T> datas;

    public BaseRecycleAdapter(List<T> datas) {
        this.datas = datas;
    }

    private View mHeaderView;
    private View mFooterView;
    public static final int ITEM_TYPE_NORMAL = 0X1111;
    public static final int ITEM_TYPE_HEADER = 0X1112;
    public static final int ITEM_TYPE_FOOTER = 0X1113;
    private boolean isHasHeader = false;
    private boolean isHasFooter = false;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==ITEM_TYPE_FOOTER){
            return new BaseViewHolder(mFooterView);
        }

        if(viewType==ITEM_TYPE_HEADER){
            return new BaseViewHolder(mHeaderView);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(),parent,false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseRecycleAdapter.BaseViewHolder holder, final int position) {

        if(isHasHeader&&isHasFooter){

            if(position==0 ||position==datas.size()+1){
                return;
            }
            bindData(holder,position-1);
        }

        if(position!=0&&isHasHeader&&!isHasFooter){

            bindData(holder,position-1);
        }

        if(!isHasHeader&&isHasFooter){

            if(position==datas.size()){
                return;
            }
            bindData(holder,position);
        }

        if(!isHasHeader&&!isHasFooter){

            bindData(holder,position);
        }

    }

    public void setHeaderView(View header){
        this.mHeaderView = header;
        isHasHeader = true;
        notifyDataSetChanged();
    }

    public void setFooterView(View footer){
        this.mFooterView = footer;
        isHasFooter = true;
        notifyDataSetChanged();
    }



    @Override
    public int getItemViewType(int position) {

        if(isHasHeader&&position==0){
            return ITEM_TYPE_HEADER;
        }
        if(isHasHeader&&isHasFooter&&position==datas.size()+1){

            return ITEM_TYPE_FOOTER;
        }else if(!isHasHeader&&isHasFooter&&position==datas.size()){
            return ITEM_TYPE_FOOTER;
        }
        return ITEM_TYPE_NORMAL;
    }

    public void refresh(List<T> datas){
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addData(List<T> datas){
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    protected abstract void bindData(BaseViewHolder holder, int position);

    @Override
    public int getItemCount() {
        int size =  datas.size();
        if(isHasFooter)
            size ++;
        if(isHasHeader)
            size++;
        return size;
    }


    public class BaseViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        private Map<Integer, View> mViewMap;

        public BaseViewHolder(View itemView) {
            super(itemView);
            mViewMap = new HashMap<>();
        }

        public View getView(int id) {
            View view = mViewMap.get(id);
            if (view == null) {
                view = itemView.findViewById(id);
                mViewMap.put(id, view);
            }
            return view;
        }

        @Override
        public void onClick(View v) {

        }
    }
    public abstract int getLayoutId();

    public void setItemText(View view,String text){
        if(view instanceof TextView){
            ((TextView) view).setText(text);
        }
    }
}
