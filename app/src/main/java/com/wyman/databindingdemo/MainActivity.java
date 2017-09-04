package com.wyman.databindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wyman.databindingdemo.databinding.ActivityMainBinding;
import com.wyman.databindingdemo.databinding_bindadapter.BindAdapterActivity;
import com.wyman.databindingdemo.databindingbean.DataBindingBeanActivity;
import com.wyman.databindingdemo.databindingrecyclerview.DataBindingRecyclerActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {

    private ActivityMainBinding mActivityMainBinding;
    private RecyclerView mRecyclerView;
    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取到当前布局文件的databinding
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        init();
    }

    private void init(){
        mRecyclerView = mActivityMainBinding.mainRecyclerview;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        datas = initDatas();
        MainAdapter<String> adapter = new MainAdapter<>(this,datas);
        adapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * 这里存数据
     * */
    private List<String> initDatas() {
        datas = new ArrayList<>();
        datas.add("DataBinding中使用RecycclerView");
        datas.add("DataBinding中View与Bean绑定");
        datas.add("BingdingAdapter使用");
        return datas;
    }

    /**
     * MainAdapter的item点击事件
     * */
    @Override
    public void onItemClick(View view, int position) {
        String text = datas.get(position);
        if(text.equals("DataBinding中使用RecycclerView")){
            startActivity(new Intent(this,DataBindingRecyclerActivity.class));
        } else if(text.equals("DataBinding中View与Bean绑定")){
            startActivity(new Intent(this,DataBindingBeanActivity.class));
        } else if(text.equals("BingdingAdapter使用")){
            startActivity(new Intent(this,BindAdapterActivity.class));
        }
    }
}
