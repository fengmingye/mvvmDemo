package com.netease.mvvmdemo.dto;

import android.view.View;

import java.io.Serializable;

public class User implements Serializable {
    public String name;
    public String address;
    private View.OnClickListener pushClick;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public User(String name, String address, View.OnClickListener pushClick) {
        this.name = name;
        this.address = address;
        this.pushClick = pushClick;
    }

    public View.OnClickListener getPushClick() {
        return pushClick;
    }

    public void setPushClick(View.OnClickListener pushClick) {
        this.pushClick = pushClick;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
