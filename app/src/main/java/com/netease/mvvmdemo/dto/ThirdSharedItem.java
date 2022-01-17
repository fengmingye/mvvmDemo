package com.netease.mvvmdemo.dto;

import android.view.View;

import java.io.Serializable;

public class ThirdSharedItem implements Serializable {
    private String shareHint;
    private String shareIcon;

    public ThirdSharedItem(String shareHint, String shareIcon) {
        this.shareHint = shareHint;
        this.shareIcon = shareIcon;
    }

    public String getShareHint() {
        return shareHint;
    }

    public void setShareHint(String shareHint) {
        this.shareHint = shareHint;
    }

    public String getShareIcon() {
        return shareIcon;
    }

    public void setShareIcon(String shareIcon) {
        this.shareIcon = shareIcon;
    }
}
