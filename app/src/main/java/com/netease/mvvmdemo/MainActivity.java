package com.netease.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.netease.mvvmdemo.config.DataBindingConfig;
import com.netease.mvvmdemo.databinding.ActivityMainBinding;
import com.netease.mvvmdemo.model.MainModel;
import com.netease.mvvmdemo.view.MainView;
import com.netease.mvvmdemo.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    ActivityMainBinding binding;
    MainView mmainView;
    MainModel mainModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
//        mainViewModel = getActivityViewModel(MainViewModel.class);
        mainModel = new MainModel(this, "requestParms");
        mainViewModel.setMainModel(mainModel);

        mmainView = new MainView(this, binding, mainViewModel);
        mmainView.init();

        mainViewModel.fetchData();
    }

}