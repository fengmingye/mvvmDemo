package com.netease.mvvmdemo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.netease.mvvmdemo.Interface.FetchDataCb;
import com.netease.mvvmdemo.dto.Cusotmer;
import com.netease.mvvmdemo.model.SecondModel;

import java.util.List;

public class SecondViewModel extends ViewModel {
    SecondModel secondModel;

    public MutableLiveData<List<Cusotmer>> mcustomers;

    private MutableLiveData<String> hint;

    public SecondViewModel() {
        mcustomers = new MutableLiveData<List<Cusotmer>>();
        hint = new MutableLiveData<>();
    }

    public MutableLiveData<String> getHint() {
        return hint;
    }

    public void setHint(MutableLiveData<String> hint) {
        this.hint = hint;
    }

    public void setSecondModel(SecondModel secondModel) {
        this.secondModel = secondModel;
    }

    public void fetchData() {
        if (this.secondModel != null) {
            this.secondModel.fetchData(new FetchDataCb() {
                @Override
                public void onResult(List<Cusotmer> datas) {
                    mcustomers.setValue(datas);
                    hint.setValue("after fetch");
                }

                @Override
                public void onError(int code, String msg) {

                }
            });
        }
    }
}
