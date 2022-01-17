package com.netease.mvvmdemo;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.netease.mvvmdemo.fragment.ThirdActivityFragment;
import com.netease.mvvmdemo.fragment.ThirdActivityStaffFragment;


public class ThirdActivity extends AppCompatActivity {
    private static final int FRAGMENT_FIRST = 1;
    private static final int FRAGMENT_SECOND = 2;
    private ThirdActivityFragment mainFragment;
    private ThirdActivityStaffFragment staffFragment;
    private int which = FRAGMENT_FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        mainFragment = new ThirdActivityFragment();
        staffFragment = new ThirdActivityStaffFragment();
        switchFragment();
        findViewById(R.id.bt_switch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchFragment();
            }
        });
    }


    private void switchFragment() {
        Fragment from, to;
        if (which == FRAGMENT_FIRST) {
            if (mainFragment == null) {
                mainFragment = new ThirdActivityFragment();
            }
            from = mainFragment;
            to = staffFragment;
            which = FRAGMENT_SECOND;
        } else {
            if (staffFragment == null) {
                staffFragment = new ThirdActivityStaffFragment();
            }
            from = staffFragment;
            to = mainFragment;
            which = FRAGMENT_FIRST;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (from != null) {
            transaction.hide(from);
        }

        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.add(R.id.fragment_container, to); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.show(to); // 隐藏当前的fragment，显示下一个
        }

        try {
            transaction.commit();
        } catch (Exception ignored) {
        }
    }

    ;
}