package com.netease.mvvmdemo.view;

import android.content.Context;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.netease.mvvmdemo.adapters.CustomerAdapter;
import com.netease.mvvmdemo.databinding.ActivityThirdFragmentMainBinding;
import com.netease.mvvmdemo.dto.Cusotmer;
import com.netease.mvvmdemo.dto.ThirdSharedItem;
import com.netease.mvvmdemo.fragment.ThirdActivityStaffFragment;
import com.netease.mvvmdemo.viewmodels.SharedThirdViewModel;
import com.netease.mvvmdemo.viewmodels.ThridViewModel;

import java.util.ArrayList;
import java.util.List;

public class ThirdView {

    private Fragment mcontext;
    private ActivityThirdFragmentMainBinding binding;
    private ThridViewModel viewModel;
    private CustomerAdapter adapter;
    private List<Cusotmer> datas;
    private SharedThirdViewModel msharedViewModel;

    public ThirdView(Fragment mcontext, ActivityThirdFragmentMainBinding binding, ThridViewModel viewModel) {
        this(mcontext, binding, viewModel, null);
    }

    public ThirdView(Fragment mcontext, ActivityThirdFragmentMainBinding binding, ThridViewModel viewModel, SharedThirdViewModel sharedViewModel) {
        this.mcontext = mcontext;
        this.binding = binding;
        this.viewModel = viewModel;
        this.msharedViewModel = sharedViewModel;
        datas = new ArrayList<>();
    }

    public void init() {
        initView();
        initClick();
        initObserve();
    }

    private void initView() {
        datas.clear();
        adapter = new CustomerAdapter(datas);
        binding.ryRyclelist.setLayoutManager(new LinearLayoutManager(mcontext.getActivity(), RecyclerView.VERTICAL, false));
        binding.ryRyclelist.setAdapter(adapter);
        binding.setThirdVm(viewModel); //绑定VM以后，VM中有数据变动就会自动更新ui
    }

    private void initClick() {
        binding.btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cusotmer mnew = new Cusotmer("name" + (int) (Math.random() * 10 + 1), "address" + (int) (Math.random() * 10 + 1));
                List<Cusotmer> newData = viewModel.mcustomers.getValue();
                newData.add(mnew);
                viewModel.mcustomers.setValue(newData);
                viewModel.getHint().setValue(mcontext instanceof ThirdActivityStaffFragment ? "staff" + (int) (Math.random() * 10 + 1) : "main" + +(int) (Math.random() * 10 + 1));
                if (msharedViewModel != null) {
                    msharedViewModel.select(new ThirdSharedItem("message from staff", "iconUrl staff"));
                }
            }
        });
    }

    private void initObserve() {
        this.viewModel.mcustomers.observe(mcontext.getViewLifecycleOwner(), new Observer<List<Cusotmer>>() {
            @Override
            public void onChanged(List<Cusotmer> users) {
                adapter.updateDatas(users);
                adapter.notifyDataSetChanged();
            }
        });
        this.viewModel.getHint().observe(mcontext.getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
//                binding.setSecondVm();
                System.out.println("呼呼呼呼");
            }
        });
    }
}
