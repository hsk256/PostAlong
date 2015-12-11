package com.postalong.modle.service;


import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by heshaokang on 2015/12/11.
 */
public class ServiceClient {
    private static ServiceClient instance = null;
    private static final String BASE_URL = "http://202.202.43.107:8083";
    private APIService APIService;


    private ServiceClient() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
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
