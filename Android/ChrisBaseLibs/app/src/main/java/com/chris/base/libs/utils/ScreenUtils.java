package com.chris.base.libs.utils;

import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.chris.base.libs.manager.UtilsManager;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.utils
 * Created by Chris Chen on 2017/7/3 14:54.
 * Explain:屏幕工具类
 */

public class ScreenUtils extends UtilsManager {
    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getWidth() {
        return getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getHeight() {
        return getDisplayMetrics().heightPixels;
    }

    /**
     * 获取状态栏高度
     *
     * @return
     */
    public static int getStatueBarHeight() {
        int identifier = mContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return mContext.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static DisplayMetrics getDisplayMetrics() {
        WindowManager windowManager = (WindowManager) mContext.getSystemService(mContext.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

}
