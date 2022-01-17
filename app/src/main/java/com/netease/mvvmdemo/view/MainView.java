package com.netease.mvvmdemo.view;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.netease.mvvmdemo.SecondActivity;
import com.netease.mvvmdemo.databinding.ActivityMainBinding;
import com.netease.mvvmdemo.dto.User;
import com.netease.mvvmdemo.viewmodels.MainViewModel;

public class MainView {

    private Activity mactivity;
    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    public MainView(Activity mactivity, ActivityMainBinding binding, MainViewModel viewModel) {
        this.mactivity = mactivity;
        this.binding = binding;
        this.viewModel = viewModel;
    }

    public void init() {
        initView();
        initClick();
        initObserve();
    }

    private void initView() {
        binding.setVm(viewModel); //绑定VM以后，VM中有数据变动就会自动更新ui
    }

    private void initClick() {
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.muser.setValue(new User(binding.edtUser.getText().toString(), binding.edtaddress.getText().toString(), viewModel.muser.getValue().getPushClick()));
            }
        });
        binding.setPushClick(v -> {
            Intent toSecondActivity = new Intent(mactivity, SecondActivity.class);
            mactivity.startActivity(toSecondActivity);
        });
//        binding.btPushClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent toSecondActivity = new Intent(mactivity, SecondActivity.class);
//                mactivity.startActivity(toSecondActivity);
//            }
//        });
//        viewModel.muser.getValue().setPushClick(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent toSecondActivity = new Intent(mactivity, SecondActivity.class);
//                mactivity.startActivity(toSecondActivity);
//            }
//        });

    }

    private void initObserve() {
        this.viewModel.muser.observe((LifecycleOwner) mactivity, new Observer<User>() {
            @Override
            public void onChanged(User user) {
//                binding.setUserInfo(user);
            }
        });
        this.viewModel.getName().observe((LifecycleOwner) mactivity, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(mactivity, "change " + s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
