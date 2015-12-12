package com.postalong.modle.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshaokang on 2015/12/12.
 */
public class OrderList {
    private String finTime;
    private String gName;
    private String gWeight;
    private String info;
    private String money;
    private String orderId;
    private String receiveAddr;
    private String sendAddr;
    private Double sendJd;
    private Double sendWd;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }


    public String getFinTime() {
        return finTime;
    }

    public void setFinTime(String finTime) {
        this.finTime = finTime;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public String getgWeight() {
        return gWeight;
    }

    public void setgWeight(String gWeight) {
        this.gWeight = gWeight;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getReceiveAddr() {
        return receiveAddr;
    }

    public void setReceiveAddr(String receiveAddr) {
        this.receiveAddr = receiveAddr;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSendAddr() {
        return sendAddr;
    }

    public void setSendAddr(String sendAddr) {
        this.sendAddr = sendAddr;
    }

    public Double getSendJd() {
        return sendJd;
    }

    public void setSendJd(Double sendJd) {
        this.sendJd = sendJd;
    }

    public Double getSendWd() {
        return sendWd;
    }

    public void setSendWd(Double sendWd) {
        this.sendWd = sendWd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
