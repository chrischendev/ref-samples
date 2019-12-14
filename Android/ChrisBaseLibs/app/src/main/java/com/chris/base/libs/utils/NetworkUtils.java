package com.chris.base.libs.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.chris.base.libs.manager.UtilsManager;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.utils
 * Created by Chris Chen on 2017/7/3 15:37.
 * Explain:网络管理工具类
 */

public class NetworkUtils extends UtilsManager {
    /**
     * 判断网络是否连接
     *
     * @return
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null) {
            return networkInfo.isAvailable();
        }
        return false;
    }

    /**
     * 判断WIFI是否连接
     *
     * @return
     */
    public static boolean isWifiConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (networkInfo != null) {
            return networkInfo.isAvailable();
        }
        return false;
    }

    /**
     * 判断3G/4G网络是否连接
     *
     * @return
     */
    public static boolean isMoblieConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null) {
            return networkInfo.isAvailable();
        }
        return false;
    }
}
