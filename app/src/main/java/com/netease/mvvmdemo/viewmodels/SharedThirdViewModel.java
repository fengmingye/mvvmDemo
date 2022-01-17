package com.netease.mvvmdemo.viewmodels;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.netease.mvvmdemo.dto.ThirdSharedItem;

public class SharedThirdViewModel extends ViewModel {
    private final MutableLiveData<ThirdSharedItem> selected = new MutableLiveData<ThirdSharedItem>();

    public void select(ThirdSharedItem item) {
        selected.setValue(item);
    }

    public LiveData<ThirdSharedItem> getSelected() {
        return selected;
    }
}