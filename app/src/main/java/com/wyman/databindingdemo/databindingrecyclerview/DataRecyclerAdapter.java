package com.wyman.databindingdemo.databindingrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyman.databindingdemo.BR;
import com.wyman.databindingdemo.R;
import com.wyman.databindingdemo.databinding.RecyclerDatabindingItemBinding;

import java.util.List;

/**
 * Created by Gww on 2017/9/4.
 */

public class DataRecyclerAdapter extends RecyclerView.Adapter<DataRecyclerAdapter.ViewHolder>{

    private List<DataBindingRecyclerBean> mList;

    public DataRecyclerAdapter(List<DataBindingRecyclerBean> list){
        this.mList = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerDatabindingItemBinding binding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext())
                        ,R.layout.recycler_databinding_item,parent,false);
        ViewHolder holder = new ViewHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //将数据与itemview绑定
        holder.mItemBinding.setBean(mList.get(position));

        //第二种写法
//        holder.mItemBinding.setVariable(BR.dataDate,mList.get(position).getDataDate());
//        holder.mItemBinding.setVariable(BR.dataMsg,mList.get(position).getDataMsg());
//        holder.mItemBinding.setVariable(BR.dataName,mList.get(position).getDataName());
//        holder.mItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerDatabindingItemBinding mItemBinding;
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setBinding(RecyclerDatabindingItemBinding binding){
            this.mItemBinding = binding;
        }

        public RecyclerDatabindingItemBinding getItemBinding(){
            return  mItemBinding;
        }
    }
}
