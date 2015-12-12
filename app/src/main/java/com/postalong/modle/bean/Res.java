package com.postalong.modle.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by heshaokang on 2015/12/12.
 */
public class Res {
    private String sortType;

    public List<OrderList> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderList> orderList) {
        this.orderList = orderList;
    }

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    private List<OrderList> orderList = new ArrayList<OrderList>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();



}
