package com.postalong.modle;

import com.postalong.modle.bean.DeliverInfo;
import com.postalong.modle.service.BaseTransfrom;
import com.postalong.modle.service.ServiceClient;

import java.util.Map;

import rx.Observable;

/**
 * Created by heshaokang on 2015/12/13.
 */
public class OrderModel {
    /**
     * 获取订单列表
     * @param params
     * @return
     */
    public static Observable<DeliverInfo> getOrdertList(Map<String,String> params) {
        return ServiceClient.getInstance().getAPIService().getOrdertList(params)
                .compose(new BaseTransfrom<DeliverInfo>());

    }


}
