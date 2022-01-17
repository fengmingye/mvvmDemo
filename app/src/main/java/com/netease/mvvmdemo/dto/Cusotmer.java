package com.netease.mvvmdemo.dto;

import android.view.View;

import java.io.Serializable;

public class Cusotmer implements Serializable {
    public String name;
    public String address;
    private String iconUrl;

    public Cusotmer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Cusotmer(String name, String address, String iconUrl) {
        this.name = name;
        this.address = address;
        this.iconUrl = iconUrl;
    }

    public Cusotmer(String name, String address, View.OnClickListener pushClick) {
        this.name = name;
        this.address = address;
    }

    public String getIconUrl() {
        return iconUrl;
    }


    //    public String getName() {
//        return name;
//    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getAddress() {
//        return address;
//    }

}
