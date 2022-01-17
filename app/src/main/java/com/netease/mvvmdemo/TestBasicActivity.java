package com.netease.mvvmdemo;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;

import com.netease.mvvmdemo.basic.BaseActivity;
import com.netease.mvvmdemo.config.DataBindingConfig;
import com.netease.mvvmdemo.databinding.ActivitySecondBinding;
import com.netease.mvvmdemo.model.SecondModel;
import com.netease.mvvmdemo.view.TestBasicView;
import com.netease.mvvmdemo.viewmodels.SecondViewModel;


public class TestBasicActivity extends BaseActivity {

    SecondViewModel mainViewModel;

    @Override
    protected void initViewModel() {
//        mainViewModel = new ViewModelProvider(this).get(SecondViewModel.class);
        mainViewModel = getActivityViewModel(SecondViewModel.class);
        SecondModel msecondM = new SecondModel(this, "requestparams");
        mainViewModel.setSecondModel(msecondM);
    }

    @Override
    protected DataBindingConfig getDataBindingConfig() {
        return new DataBindingConfig(R.layout.activity_second);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TestBasicView mmainView = new TestBasicView(this, (ActivitySecondBinding) getmBinding(), mainViewModel, this);
        mainViewModel.fetchData();
    }
}