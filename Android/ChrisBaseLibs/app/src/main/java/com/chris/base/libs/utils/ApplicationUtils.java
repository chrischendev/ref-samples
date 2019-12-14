package com.chris.base.libs.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.chris.base.libs.manager.UtilsManager;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.utils
 * Created by Chris Chen on 2017/7/3 16:22.
 * Explain:Application工具类
 */

public class ApplicationUtils extends UtilsManager {
    /**
     * 获取版本号
     *
     * @return
     */
    public static int getVersionCode() {
        try {
            return mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取版本名称
     *
     * @return
     */
    public static String getVersionName() {
        try {
            return mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取应用程序名
     *
     * @return
     */
    public static String getAppName() {
        try {
            PackageManager packageManager = mContext.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(mContext.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return mContext.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
