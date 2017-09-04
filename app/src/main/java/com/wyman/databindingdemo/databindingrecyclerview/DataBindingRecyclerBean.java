package com.wyman.databindingdemo.databindingrecyclerview;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wyman.databindingdemo.BR;

/**
 * 监听对象字段的变动
 */
public class DataBindingRecyclerBean extends BaseObservable{

    private String dataName;
    private String dataDate;
    private String dataMsg;

    @Bindable
    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
        notifyPropertyChanged(BR.dataName);
    }

    @Bindable
    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
        notifyPropertyChanged(BR.dataDate);
    }

    @Bindable
    public String getDataMsg() {
        return dataMsg;
    }

    public void setDataMsg(String dataMsg) {
        this.dataMsg = dataMsg;
        notifyPropertyChanged(BR.dataMsg);
    }
}
