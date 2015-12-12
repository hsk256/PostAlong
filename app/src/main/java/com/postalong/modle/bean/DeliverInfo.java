package com.postalong.modle.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshaokang on 2015/12/12.
 */
public class DeliverInfo {
    private Integer ret;
    private Res res;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public Res getRes() {
        return res;
    }

    public void setRes(Res res) {
        this.res = res;
    }

    public Integer getRet() {
        return ret;
    }

    public void setRet(Integer ret) {
        this.ret = ret;
    }
}
