package com.postalong.base;

import android.app.Application;

import com.postalong.utils.BaseUtils;

/**
 * Created by heshaokang on 2015/12/13.
 */
public class GlobalApp extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        BaseUtils.initialize(this);//初始化BaseUtil
    }
}
