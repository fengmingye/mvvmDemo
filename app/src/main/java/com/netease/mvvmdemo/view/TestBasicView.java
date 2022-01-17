package com.netease.mvvmdemo.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.netease.mvvmdemo.ThirdActivity;
import com.netease.mvvmdemo.adapters.CustomerAdapter;
import com.netease.mvvmdemo.basic.BasicView;
import com.netease.mvvmdemo.databinding.ActivitySecondBinding;
import com.netease.mvvmdemo.dto.Cusotmer;
import com.netease.mvvmdemo.viewmodels.SecondViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 依次执行initView，initClick，initObserve方法，且这三个方法调用时机在该类的构造函数super方法中
 * initView进行数据以及界面相关初始化
 */

public class TestBasicView extends BasicView {
    private ActivitySecondBinding binding;
    private SecondViewModel viewModel;
    private CustomerAdapter adapter;
    private List<Cusotmer> datas;
    private String[] urls;

    public TestBasicView(Context mcontext, ViewDataBinding binding, ViewModel viewModel, LifecycleOwner lifecycleOwner) {
        super(mcontext, binding, viewModel, lifecycleOwner);
    }

    @Override
    protected void initView() {
        this.binding = (ActivitySecondBinding) getBinding();
        this.viewModel = (SecondViewModel) getVm();
        datas = new ArrayList<>();
        urls = new String[]{"https://urchin.nosdn.127.net/c23e0b62550c4e40af9a420f1c27bd2f", "https://urchin.nosdn.127.net/MTAwMTA3Nw%3D%3D%2FdXJjaGlud18xMDQ2XzE1ODk2MDUzOTgxNjFfNmNkZTk4YjMtZmMyYy00Y2ZkLWFkZGUtZGZhYzk5NjEyNWFl", "https://urchin.nosdn.127.net/2e25e24dcde5440485cc70186f3ebb9d"};
        datas.clear();
        adapter = new CustomerAdapter(datas);

        binding.ryRyclelist.setLayoutManager(new LinearLayoutManager(getMcontext(), RecyclerView.VERTICAL, false));
        binding.ryRyclelist.setAdapter(adapter);
        binding.setSecondVm(viewModel); //绑定VM以后，VM中有数据变动就会自动更新ui
    }

    @Override
    protected void initClick() {
        binding.btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cusotmer mnew = new Cusotmer("name" + (int) (Math.random() * 10 + 1), "address" + (int) (Math.random() * 10 + 1), getUrl());
                List<Cusotmer> newData = viewModel.mcustomers.getValue();
                newData.add(mnew);
                viewModel.mcustomers.setValue(newData);
                viewModel.getHint().setValue("newyho" + Math.random());
            }
        });
        binding.setPusthClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toThirdActivity = new Intent(getMcontext(), ThirdActivity.class);
                getMcontext().startActivity(toThirdActivity);
            }
        });
    }

    @Override
    protected void initObserve() {
        this.viewModel.mcustomers.observe(getLifecycleOwner(), new Observer<List<Cusotmer>>() {
            @Override
            public void onChanged(List<Cusotmer> users) {
                adapter.updateDatas(users);
                adapter.notifyDataSetChanged();
            }
        });
        this.viewModel.getHint().observe(getLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
//                binding.setSecondVm();
                System.out.println("呼呼呼呼");
            }
        });
    }


    private String getUrl() {
        int index = (int) (Math.random() * 2);
        return urls[index];
    }

}
