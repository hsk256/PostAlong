package com.postalong.modle.service;


import com.postalong.base.Api;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by heshaokang on 2015/12/11.
 *
 * 功能：创建Retrofit网络框架，返回单例
 */
public class ServiceClient {
    private static ServiceClient instance = null;
    private APIService APIService;


    private ServiceClient() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(Api.BASE_URL_CAMPUS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        APIService = retrofit.create(APIService.class);
    }

    public static ServiceClient getInstance() {
        if(instance==null) {
            synchronized (ServiceClient.class) {
                if(instance==null) {
                    instance =  new ServiceClient();
                }
            }
        }
        return instance;
    }

    public APIService getAPIService() {
        return APIService;
    }
}
