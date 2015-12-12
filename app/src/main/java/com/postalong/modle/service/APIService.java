package com.postalong.modle.service;

import com.postalong.modle.bean.DeliverInfo;

import java.util.Map;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by heshaokang on 2015/12/11.
 * 所有的请求接口
 */
public interface APIService {

    @FormUrlEncoded
    @POST("/api/deliver/goodList")
    Call<DeliverInfo> getGoodList(@FieldMap Map<String,String> paramsMap);

    @FormUrlEncoded
    @POST("/api/deliver/goodList")
    Observable<DeliverInfo> getProductList(@FieldMap Map<String,String> paramsMap);
}
