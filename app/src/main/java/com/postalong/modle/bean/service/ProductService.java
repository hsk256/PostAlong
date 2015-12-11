package com.postalong.modle.bean.service;

import java.util.Map;

import retrofit.http.FieldMap;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by heshaokang on 2015/12/11.
 */
public interface ProductService {
    @POST("api/deliver/goodList")
    void getGoodList(@FieldMap Map<String,String> paramsMap)


}
