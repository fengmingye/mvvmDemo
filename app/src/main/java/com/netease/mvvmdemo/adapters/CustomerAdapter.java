package com.netease.mvvmdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.netease.mvvmdemo.R;
import com.netease.mvvmdemo.databinding.ActivitySecondItemBinding;
import com.netease.mvvmdemo.dto.Cusotmer;
import com.netease.mvvmdemo.dto.User;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerViewHolder> {
    private List<Cusotmer> mitems;
    private Context mcontext;

    private OnItemClickListener<Cusotmer> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<Cusotmer> onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mcontext = parent.getContext();
        return new CustomerViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.activity_second_item,
                        parent,
                        false
                )
        );
    }

    public CustomerAdapter(List<Cusotmer> mitems) {
        this.mitems = mitems;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        holder.bind(this.mitems.get(position), mcontext);
    }

    public void updateDatas(List<Cusotmer> mitems) {
        this.mitems.clear();
        this.mitems.addAll(mitems);
    }


    @Override
    public int getItemCount() {
        return this.mitems.size();
    }
}

interface OnItemClickListener<M> {
    void onItemClick(M item, int position);
}


class CustomerViewHolder extends RecyclerView.ViewHolder {

    private ActivitySecondItemBinding binding;

    public CustomerViewHolder(ActivitySecondItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Cusotmer itemData, Context mcontext) {
        binding.setCusotmer(itemData);
//        Glide.with(mcontext).load(itemData.getIconUrl()).asBitmap().override(120, 100).dontAnimate().placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher_foreground).into(binding.ivIcon);
        binding.setItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, itemData.name + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
        if (binding != null) {
            binding.executePendingBindings(); //解决页面刷新闪烁的问题
        }
    }
}
