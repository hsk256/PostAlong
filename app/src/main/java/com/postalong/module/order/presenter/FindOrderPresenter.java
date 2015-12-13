package com.postalong.module.order.presenter;

import com.postalong.base.BasePresenter;
import com.postalong.base.Constants;
import com.postalong.modle.OrderModel;
import com.postalong.modle.bean.DeliverInfo;
import com.postalong.modle.bean.OrderList;
import com.postalong.module.order.view.FindOrderView;
import com.postalong.utils.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;

/**
 * Created by heshaokang on 2015/12/12.
 */
public class FindOrderPresenter extends BasePresenter<FindOrderView>{
    public static final String TAG = "FindOrderPresenter";
    private ArrayList<OrderList> orderLists = new ArrayList<>();
    public void getOrderList() {
        Map paramsMap = new HashMap();
        paramsMap.put("page","1");
        paramsMap.put("pageSize","10");
        paramsMap.put("curJd","106.6007045");
        paramsMap.put("curWd","29.5342324");
        paramsMap.put("sortType", "dist");
        paramsMap.put("sortVal", "asc");
        paramsMap.put("reqTime", "2015-12-12 12:30:04");
        OrderModel.getOrdertList(paramsMap)
                .doOnError(throwable -> {
                    Log.d(TAG, "doOnError");
                })
                .subscribe(new Subscriber<DeliverInfo>() {

                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "e--" + e);
                    }

                    @Override
                    public void onNext(DeliverInfo deliverInfo) {
                        if (deliverInfo.getRet() == Constants.RES_SUCCESS) {
                            for (OrderList orderList:deliverInfo.getRes().getOrderList()) {
                                orderLists.add(orderList);
                            }
                            getView().setData(orderLists);
                        }


                    }
                });
    }

}
