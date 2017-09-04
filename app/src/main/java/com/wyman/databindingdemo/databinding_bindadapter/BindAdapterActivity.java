package com.wyman.databindingdemo.databinding_bindadapter;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.wyman.databindingdemo.R;
import com.wyman.databindingdemo.databinding.BindadapterLayoutBinding;

/**
 * 注解 @BindAdapter 用法
 */
public class BindAdapterActivity extends AppCompatActivity {

    private BindadapterLayoutBinding mBinding;
    private static Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.bindadapter_layout);
        mContext = this;

        //往 testName 注值
        mBinding.setTestName("testName");
    }

    // 使用注解，无需手动调用此函数
    @BindingAdapter({"testName","error"})
    public static void testBinddingAdapter(View view,String testName,String error){
        String text = "";
        if(TextUtils.isEmpty(testName)){
            text = error;
        } else {
            text = testName;
        }
        Toast.makeText(mContext,text,Toast.LENGTH_LONG).show();
    }

    boolean flag = false;
    public void onClick(View view){
        if(flag){
            mBinding.setTestName(null);
            flag = false;
        } else {
            mBinding.setTestName("bindadapter");
            flag = true;
        }
    }
}
