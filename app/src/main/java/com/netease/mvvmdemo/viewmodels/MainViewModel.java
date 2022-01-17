package com.netease.mvvmdemo.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.netease.mvvmdemo.Interface.FetchDataCb;
import com.netease.mvvmdemo.dto.Cusotmer;
import com.netease.mvvmdemo.dto.User;
import com.netease.mvvmdemo.model.MainModel;

import java.util.ArrayList;
import java.util.List;


public class MainViewModel extends ViewModel {
    MainModel mainModel;
    public MutableLiveData<User> muser;
    private MutableLiveData<String> name;
    public MutableLiveData<String> address;

    public MainViewModel() {
        muser = new MutableLiveData<>();
        name = new MutableLiveData<>();
        address = new MutableLiveData<>();
    }

    public void setMainModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void fetchData() {
        if (mainModel != null) {
            muser.setValue(mainModel.fetchData());
        }
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<String> getAddress() {
        return address;
    }

}
