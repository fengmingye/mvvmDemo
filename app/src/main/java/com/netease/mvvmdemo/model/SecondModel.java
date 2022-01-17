package com.netease.mvvmdemo.model;

import android.content.Context;

import com.netease.mvvmdemo.Interface.FetchDataCb;
import com.netease.mvvmdemo.dto.Cusotmer;

import java.util.ArrayList;
import java.util.List;

public class SecondModel {
    private String param;
    private Context mcontext;

    public SecondModel(Context mcontext, String param) {
        this.param = param;
        this.mcontext = mcontext;
    }

    public void fetchData(FetchDataCb cb) {
//      fetch data from network
        List<Cusotmer> response = new ArrayList<>();
        response.add(new Cusotmer("firstName", "firstAddress", "https://urchin.nosdn.127.net/2e25e24dcde5440485cc70186f3ebb9d"));
        response.add(new Cusotmer("secondtName", "secondAddress", "https://urchin.nosdn.127.net/65f6c54e551743cb9edeef86b2ea8849"));
        response.add(new Cusotmer("thirdName", "thirdAddress", "https://urchin.nosdn.127.net/c23e0b62550c4e40af9a420f1c27bd2f"));
        response.add(new Cusotmer("fourthName", "fourthAddress", "https://urchin.nosdn.127.net/MTAwMTA3Nw%3D%3D%2FdXJjaGlud18xMDQ2XzE1ODk2MDUzOTgxNjFfNmNkZTk4YjMtZmMyYy00Y2ZkLWFkZGUtZGZhYzk5NjEyNWFl"));
        response.add(new Cusotmer("fiveName", "fiveAddress", "http://wx.qlogo.cn/mmhead/ver_1/eb4h6v4CuRVRhqH6rdR9JW9neAhqO8XE4wJ0U6Max40mL482ibWn8uZUMrLs260I7doicicLPkjbl71aNpIxqRwJ54lzYj2GgEl4ibUp7CJhIHU/132"));
        if (cb != null) {
            cb.onResult(response);
        }
    }

}


