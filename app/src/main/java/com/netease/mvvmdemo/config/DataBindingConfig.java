package com.netease.mvvmdemo.config;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.netease.mvvmdemo.basic.BasicView;
import com.netease.mvvmdemo.view.SecondView;

public class DataBindingConfig<T extends ViewModel, V extends BasicView> {
    private final int layout;

    public DataBindingConfig(int layout) {
        this.layout = layout;
    }

    public int getLayout() {
        return this.layout;
    }


    //    public DataBindingConfig addBindingParam(@NonNull Integer variableId, @NonNull Object object) {
//        if (this.bindingParams.get(variableId) == null) {
//            this.bindingParams.put(variableId, object);
//        }
//
//        return this;
//    }
}
