package com.postalong.modle.service;

import com.postalong.modle.bean.DeliverInfoDto;

import java.util.List;
import java.util.Map;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by heshaokang on 2015/12/11.
 */
public interface APIService {

    @FormUrlEncoded
    @POST("/api/deliver/goodList")
    Call<List<DeliverInfoDto.DeliverInfo>> getGoodList(@FieldMap Map<String,String> paramsMap);

}
