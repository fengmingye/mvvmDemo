package com.netease.mvvmdemo.basic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.netease.mvvmdemo.MyApplication;
import com.netease.mvvmdemo.config.DataBindingConfig;

public abstract class BaseActivity extends AppCompatActivity {
    ViewModelProvider mApplicationProvider;
    ViewModelProvider mActivityProvider;
    private ViewDataBinding mBinding;

    /**
     * 获取Activity级别的VM
     *
     * @param modelClass
     * @param <T>
     * @return
     */
    protected <T extends ViewModel> T getActivityViewModel(@NonNull Class<T> modelClass) {
        if (mActivityProvider == null) {
            mActivityProvider = new ViewModelProvider(this);
        }
        return mActivityProvider.get(modelClass);
    }

    /**
     * 获取全局共享Application级别的VM
     *
     * @param modelClass
     * @param <T>
     * @return
     */
    protected <T extends ViewModel> T getApplicationScopeViewModel(@NonNull Class<T> modelClass) {
        if (mApplicationProvider == null) {
            mApplicationProvider = new ViewModelProvider((MyApplication) this.getApplicationContext());
        }
        return mApplicationProvider.get(modelClass);
    }


    public ViewDataBinding getmBinding() {
        return mBinding;
    }

    protected abstract void initViewModel();

    protected abstract DataBindingConfig getDataBindingConfig();

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingConfig dataBindingConfig = this.getDataBindingConfig();
        mBinding = DataBindingUtil.setContentView(this, dataBindingConfig.getLayout());
        mBinding.setLifecycleOwner(this);
        this.initViewModel();


//        SparseArray<Object> bindingParams = dataBindingConfig.getBindingParams();
//        int i = 0;
//
//        for (int length = bindingParams.size(); i < length; ++i) {
//            binding.setVariable(bindingParams.keyAt(i), bindingParams.valueAt(i));
//        }
//
//        this.mBinding = binding;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.mBinding.unbind();
        this.mBinding = null;
    }
}
