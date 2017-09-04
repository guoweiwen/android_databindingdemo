package com.wyman.databindingdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * MainActivity使用的Adapter
 */
public class MainAdapter<T> extends RecyclerView.Adapter<MainAdapter.ViewHolder>{


    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mainadapter_itemlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(final MainAdapter.ViewHolder holder, int position) {
        holder.mainAdapter_item.setText(list.get(position).toString());
        if(listener != null){
            holder.mainAdapter_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    listener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list!=null ? list.size() : 0;
    }

    private List<T> list;
    private Context mContext;
    private OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public MainAdapter(Context context,List<T> datas){
        mContext = context;
        list = datas;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView mainAdapter_item;

        public ViewHolder(View itemView) {
            super(itemView);
            mainAdapter_item = (TextView)itemView.findViewById(R.id.mainAdapter_item);
        }
    }
}
