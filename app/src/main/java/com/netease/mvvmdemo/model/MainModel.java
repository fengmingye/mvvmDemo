package com.netease.mvvmdemo.model;

import android.content.Context;

import com.netease.mvvmdemo.dto.User;


public class MainModel {
    private String param;
    private Context mcontext;

    public MainModel(Context mcontext, String param) {
        this.param = param;
        this.mcontext = mcontext;
    }

    public User fetchData() {
//      fetch data from network or local
        return new User("initialName", "initialAddress");
//        List<Cusotmer> response = new ArrayList<>();
//        response.add(new Cusotmer("firstName", "firstAddress", "https://urchin.nosdn.127.net/2e25e24dcde5440485cc70186f3ebb9d"));
//        response.add(new Cusotmer("secondtName", "secondAddress", "https://urchin.nosdn.127.net/65f6c54e551743cb9edeef86b2ea8849"));
//        response.add(new Cusotmer("thirdName", "thirdAddress", "https://urchin.nosdn.127.net/c23e0b62550c4e40af9a420f1c27bd2f"));
//        response.add(new Cusotmer("fourthName", "fourthAddress", "https://urchin.nosdn.127.net/c23e0b62550c4e40af9a420f1c27bd2f"));
//        response.add(new Cusotmer("fiveName", "fiveAddress", "https://urchin.nosdn.127.net/c23e0b62550c4e40af9a420f1c27bd2f"));
//        if (cb != null) {
//            cb.onResult(response);
//        }
    }

}

