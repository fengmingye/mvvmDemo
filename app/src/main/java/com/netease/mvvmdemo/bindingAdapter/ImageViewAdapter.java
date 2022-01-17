package com.netease.mvvmdemo.bindingAdapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;


public class ImageViewAdapter {

//    @BindingAdapter("android:src")
//    public static void setSrc(ImageView view, Bitmap bitmap) {
//        view.setImageBitmap(bitmap);
//    }
//
//    @BindingAdapter("android:src")
//    public static void setSrc(ImageView view, int resId) {
//        view.setImageResource(resId);
//    }

    @BindingAdapter(value = {"app:imageUrl", "app:placeHolder", "app:error"}, requireAll = false)
    public static void loadImage(ImageView imageView, String url, Drawable holderDrawable, Drawable errorDrawable) {
        Glide.with(imageView.getContext())
                .load(url)
                .placeholder(holderDrawable)
                .error(errorDrawable)
                .into(imageView);
    }
}
