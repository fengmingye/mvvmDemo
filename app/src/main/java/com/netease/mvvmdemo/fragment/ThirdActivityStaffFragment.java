package com.netease.mvvmdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.netease.mvvmdemo.R;
import com.netease.mvvmdemo.databinding.ActivityThirdFragmentMainBinding;
import com.netease.mvvmdemo.model.ThirdModel;
import com.netease.mvvmdemo.view.ThirdView;
import com.netease.mvvmdemo.viewmodels.SharedThirdViewModel;
import com.netease.mvvmdemo.viewmodels.ThridViewModel;

public class ThirdActivityStaffFragment extends Fragment {
    ActivityThirdFragmentMainBinding binding;
    ThridViewModel mainViewModel;
    ThirdModel mModel;
    ThirdView mmainView;
    private SharedThirdViewModel msharedViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_third_fragment_main, container, false);
        binding.setLifecycleOwner(this);

        mainViewModel = new ViewModelProvider(this).get(ThridViewModel.class);
        msharedViewModel = new ViewModelProvider(getActivity()).get(SharedThirdViewModel.class);
        mModel = new ThirdModel("first");
        mainViewModel.setSecondModel(mModel);

        mmainView = new ThirdView(this, binding, mainViewModel, msharedViewModel);
        mmainView.init();

        mainViewModel.fetchData();
        return binding.getRoot();
    }
}
