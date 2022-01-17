package com.netease.mvvmdemo.basic;

import android.content.Context;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;


public abstract class BasicView<T extends ViewDataBinding, M extends ViewModel> {
    private Context mcontext;
    private LifecycleOwner lifecycleOwner;
    private T binding;
    private M vm;

    public BasicView(Context mcontext, T binding, M viewModel, LifecycleOwner lifecycleOwner) {
        this.mcontext = mcontext;
        this.lifecycleOwner = lifecycleOwner;
        this.binding = binding;
        this.vm = viewModel;
        init();
    }

    protected void init() {
        initView();
        initClick();
        initObserve();
    }

    protected abstract void initView();

    protected abstract void initClick();

    protected abstract void initObserve();

    public Context getMcontext() {
        return mcontext;
    }

    public LifecycleOwner getLifecycleOwner() {
        return lifecycleOwner;
    }

    public T getBinding() {
        return binding;
    }

    public M getVm() {
        return vm;
    }
}
