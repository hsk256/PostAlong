package com.postalong.module.order.presenter;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.postalong.modle.bean.OrderList;
import com.postalong.module.order.view.OrderViewHolder;

/**
 * Created by heshaokang on 2015/12/16.
 */
public class OrderAdapter extends RecyclerArrayAdapter<OrderList>{

    public OrderAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderViewHolder(parent);
    }
}
