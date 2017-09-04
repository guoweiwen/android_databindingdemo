package com.wyman.databindingdemo.databindingrecyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.wyman.databindingdemo.R;
import com.wyman.databindingdemo.databinding.ActivityDataBindingRecyclerBinding;

import java.util.ArrayList;
import java.util.List;

public class DataBindingRecyclerActivity extends AppCompatActivity {

    private ActivityDataBindingRecyclerBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_recycler);

        List<DataBindingRecyclerBean> datas = initDatas();
        DataRecyclerAdapter adapter = new DataRecyclerAdapter(datas);
        dataBinding.recyclerdatabindingRecyclerview.setAdapter(adapter);
        dataBinding.recyclerdatabindingRecyclerview.setLayoutManager(new LinearLayoutManager(this));;

    }

    private List<DataBindingRecyclerBean> initDatas() {
        DataBindingRecyclerBean bean1 = new DataBindingRecyclerBean();
        bean1.setDataDate("2017-03-03");
        bean1.setDataMsg("testtest1");
        bean1.setDataName("testName1");
        DataBindingRecyclerBean bean2 = new DataBindingRecyclerBean();
        bean2.setDataDate("2017-03-02");
        bean2.setDataMsg("testtest2");
        bean2.setDataName("testName2");
        List<DataBindingRecyclerBean> datas = new ArrayList<>();
        datas.add(bean1);
        datas.add(bean2);
        return datas;
    }
}
