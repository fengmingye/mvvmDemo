package com.netease.mvvmdemo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.netease.mvvmdemo.Interface.FetchDataCb;
import com.netease.mvvmdemo.dto.Cusotmer;
import com.netease.mvvmdemo.model.SecondModel;
import com.netease.mvvmdemo.model.ThirdModel;

import java.util.List;

public class ThridViewModel extends ViewModel {
    ThirdModel thirdModel;

    public MutableLiveData<List<Cusotmer>> mcustomers;

    private MutableLiveData<String> hint;

    public ThridViewModel() {
        mcustomers = new MutableLiveData<List<Cusotmer>>();
        hint = new MutableLiveData<>();
    }

    public MutableLiveData<String> getHint() {
        return hint;
    }

    public void setHint(MutableLiveData<String> hint) {
        this.hint = hint;
    }

    public void setSecondModel(ThirdModel secondModel) {
        this.thirdModel = secondModel;
    }

    public void fetchData() {
        if (this.thirdModel != null) {
            this.thirdModel.fetchData(new FetchDataCb() {
                @Override
                public void onResult(List<Cusotmer> datas) {
                    mcustomers.setValue(datas);
                    hint.setValue(thirdModel.getHint());
                }

                @Override
                public void onError(int code, String msg) {

                }
            });
        }
    }
}
