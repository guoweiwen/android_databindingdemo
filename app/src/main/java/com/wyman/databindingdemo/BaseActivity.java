package com.wyman.databindingdemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.wyman.databindingdemo.databinding.ActivityBaseBinding;

/**
 * Created by Gww on 2017/9/4.
 */

public class BaseActivity<LayoutView extends ViewDataBinding> extends AppCompatActivity {
    //用于继承自BaseActivity的xml布局文件
    protected LayoutView bindingView;
    //BaseActivity的xml布局文件
    private ActivityBaseBinding mActivityBaseBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        mActivityBaseBinding = DataBindingUtil.inflate(LayoutInflater.from(this),
                R.layout.activity_base,null,false);
        bindingView = DataBindingUtil.inflate(getLayoutInflater(),layoutResID,null,false);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //当前继承BaseActivity的布局xml文件的最外层ViewGroup
        bindingView.getRoot().setLayoutParams(layoutParams);
        //获取到BaseActivity的布局xml文件里面id为root的framlayout
        FrameLayout base_framLayout = (FrameLayout) mActivityBaseBinding.getRoot().findViewById(R.id.root);
        //将继承BaseActivity的布局xml文件的最外层的ViewGroup放在BaseActivity布局的id为root的ViewGroup上
        base_framLayout.addView(bindingView.getRoot());
        //当前的Activity重新设置ContentView
        getWindow().setContentView(mActivityBaseBinding.getRoot());
    }
}
















