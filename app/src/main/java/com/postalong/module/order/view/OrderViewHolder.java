package com.postalong.module.order.view;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.postalong.R;
import com.postalong.modle.bean.OrderList;

/**
 * Created by heshaokang on 2015/12/16.
 */
public class OrderViewHolder extends BaseViewHolder<OrderList> {

    TextView tv_goods_name;
    TextView tv_from_value;
    TextView tv_to_value;
    TextView tv_time;
    TextView tv_money;
    TextView tv_weight;

    public OrderViewHolder(ViewGroup group) {
        super(group, R.layout.item_rv_find_order);
        tv_goods_name = $(R.id.tv_goods_name);
        tv_from_value = $(R.id.tv_from_value);
        tv_to_value = $(R.id.tv_to_value);
        tv_time = $(R.id.tv_time);
        tv_money = $(R.id.tv_money);
        tv_weight = $(R.id.tv_weight);
    }

    @Override
    public void setData(OrderList data) {
        super.setData(data);
        tv_goods_name.setText(data.getgName());
        tv_from_value.setText(data.getSendAddr());
        tv_to_value.setText(data.getReceiveAddr());
        tv_time.setText(data.getFinTime());
        tv_money.setText(data.getMoney());
        tv_weight.setText(data.getgWeight());
    }
}
