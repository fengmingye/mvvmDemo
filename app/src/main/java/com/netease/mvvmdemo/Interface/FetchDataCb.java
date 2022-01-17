package com.netease.mvvmdemo.Interface;

import com.netease.mvvmdemo.dto.Cusotmer;

import java.util.List;

public interface FetchDataCb {
    void onResult(List<Cusotmer> datas);

    void onError(int code, String msg);
}