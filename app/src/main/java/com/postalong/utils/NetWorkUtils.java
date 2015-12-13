package com.postalong.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络工具类
 */
public class NetWorkUtils {

    /**
     * 获取当前网络是否可用
     */
    public static boolean isNetWorkUsed(Activity activity) {
        if (activity != null) {
            ConnectivityManager manager = (ConnectivityManager) activity
                    .getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (manager == null) {
                return false;
            }
            NetworkInfo networkinfo = manager.getActiveNetworkInfo();
            if (networkinfo == null || !networkinfo.isAvailable()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断当前使用的网络连接是不是wifi
     */
    public static boolean isWifi(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getApplicationContext().getSystemService(
                        Context.CONNECTIVITY_SERVICE);

        if (manager == null) {
            return false;
        }

        NetworkInfo networkinfo = manager.getActiveNetworkInfo();

        if (networkinfo != null && networkinfo.isAvailable()) {
            if (networkinfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            }
        }

        return false;
    }
}
