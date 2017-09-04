package com.wyman.databindingdemo.databindingbean;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wyman.databindingdemo.BaseActivity;
import com.wyman.databindingdemo.R;
import com.wyman.databindingdemo.databinding.ActivityDataBindingBeanBinding;

public class DataBindingBeanActivity extends AppCompatActivity {

    private ActivityDataBindingBeanBinding binding;
    private DataBindingBean bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_data_binding_bean);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding_bean);

        bean = new DataBindingBean();
        bean.setName("testName");
        bean.setAge("testAge");
        bean.setDes("testDes");

        //这样将view与bean进行绑定
        binding.setUser(bean);
        binding.databindingbeanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeBean(bean);
            }
        });
    }

    /**
     * 这里尝试改变bean，看textview随之改变
     * */
    private void changeBean(DataBindingBean bean) {
        bean.setDes("change testDes");
        bean.setName(null);
        binding.setUser(bean);
    }
}
