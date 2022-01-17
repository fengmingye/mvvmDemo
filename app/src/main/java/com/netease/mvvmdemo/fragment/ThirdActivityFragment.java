package com.netease.mvvmdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.netease.mvvmdemo.R;
import com.netease.mvvmdemo.databinding.ActivityThirdFragmentMainBinding;
import com.netease.mvvmdemo.dto.ThirdSharedItem;
import com.netease.mvvmdemo.model.ThirdModel;
import com.netease.mvvmdemo.view.ThirdView;
import com.netease.mvvmdemo.viewmodels.SharedThirdViewModel;
import com.netease.mvvmdemo.viewmodels.ThridViewModel;

public class ThirdActivityFragment extends Fragment {

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
        mModel = new ThirdModel("requestparams");
        mainViewModel.setSecondModel(mModel);

        mmainView = new ThirdView(this, binding, mainViewModel);
        mmainView.init();

        mainViewModel.fetchData();

        msharedViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<ThirdSharedItem>() {
            @Override
            public void onChanged(ThirdSharedItem thirdSharedItem) {
                Toast.makeText(getContext(), thirdSharedItem.getShareHint(), Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}
