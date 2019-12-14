package com.chris.base.libs.utils;

import android.util.Log;

import com.chris.base.libs.manager.UtilsManager;

import java.util.List;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.utils
 * Created by Chris Chen on 2017/7/3 16:31.
 * Explain:日志工具类
 */

public class LogUtils extends UtilsManager {
    public static final String TAG = mContext.getPackageName();

    public static void v(Object object) {
        Log.v(TAG, String.valueOf(object));
    }

    public static void d(Object object) {
        Log.d(TAG, String.valueOf(object));
    }

    public static void i(Object object) {
        Log.i(TAG, String.valueOf(object));
    }

    public static void w(Object object) {
        Log.w(TAG, String.valueOf(object));
    }

    public static void e(Object object) {
        Log.e(TAG, String.valueOf(object));
    }

    /**
     * 日志输出List集合
     *
     * @param objectList
     * @param <T>
     */
    public static <T extends Object> void i(List<T> objectList) {
        for (T t : objectList) {
            Log.e(TAG, String.valueOf(t) + "\n");
        }
    }

    /**
     * 日志输出数组
     *
     * @param objectArray
     * @param <T>
     */
    public static <T extends Object> void i(T[] objectArray) {
        for (T t : objectArray) {
            Log.e(TAG, String.valueOf(t) + "\n");
        }
    }
}
