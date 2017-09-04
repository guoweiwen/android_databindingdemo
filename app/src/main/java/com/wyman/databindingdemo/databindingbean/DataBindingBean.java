package com.wyman.databindingdemo.databindingbean;

import java.io.Serializable;

/**
 * Created by Gww on 2017/9/4.
 */

public class DataBindingBean implements Serializable{
    private String name;
    private String age;
    private String des;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
