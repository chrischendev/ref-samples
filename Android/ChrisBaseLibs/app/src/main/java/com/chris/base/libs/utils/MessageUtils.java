package com.chris.base.libs.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.chris.base.libs.manager.UtilsManager;

/**
 * com.alg.ailigouapp.library.utils
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 17:23
 * Explain:消息弹出工具类
 */

public class MessageUtils extends UtilsManager {
    private static final boolean IS_DEBUG = false;

    /**
     * 正常弹出的消息
     *
     * @param object
     */
    public static void show(Object object) {
        Toast.makeText(mContext, String.valueOf(object), Toast.LENGTH_SHORT).show();
    }

    /**
     * 正常弹出字符串资源
     *
     * @param strId
     */
    public static void showRes(@StringRes int strId) {
        Toast.makeText(mContext, mContext.getResources().getString(strId), Toast.LENGTH_SHORT).show();
    }

    /**
     * 调试状态弹出的消息
     *
     * @param object
     */
    public static void debug(Object object) {
        if (IS_DEBUG) {
            show(object);
        }
    }

    /**
     * 调试状态弹出字符串资源
     *
     * @param strId
     */
    public static void debugRes(@StringRes int strId) {
        if (IS_DEBUG) {
            showRes(strId);
        }
    }

}
