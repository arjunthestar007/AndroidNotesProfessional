package com.example.arjun.androidnotesprofessional;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.arjun.androidnotesprofessional.databinding.MyItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAdapterWithBinding extends RecyclerView.Adapter<BindingViewHolder<MyItemBinding>> {

    List<Movie> items = new ArrayList<>();

    public MyAdapterWithBinding(List<Movie> items) {
        this.items = items;
    }

    @Override
    public BindingViewHolder<MyItemBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BindingViewHolder<>(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder<MyItemBinding> myItemBindingBindingViewHolder, int i) {
        myItemBindingBindingViewHolder.getBinding().setItem(items.get(i));
        myItemBindingBindingViewHolder.getBinding().executePendingBindings();
    }


    @Override
    public int getItemCount() {
        return items.size();
    }
}
