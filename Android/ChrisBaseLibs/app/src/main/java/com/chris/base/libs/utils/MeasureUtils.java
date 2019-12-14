package com.chris.base.libs.utils;

import com.chris.base.libs.manager.UtilsManager;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.utils
 * Created by Chris Chen on 2017/7/3 14:42.
 * Explain:尺寸工具类
 */

public class MeasureUtils extends UtilsManager {
    /**
     * todo:dp2px
     *
     * @param dpValue
     * @return
     */
    public static int dp2px(float dpValue) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5);
    }

    /**
     * todo:sp2px
     *
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (spValue * scale + 0.5);
    }

    /**
     * todo:px2dp
     *
     * @param pxValue
     * @return
     */
    public static int px2dp(int pxValue) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5);
    }

    /**
     * todo:px2sp
     *
     * @param pxValue
     * @return
     */
    public static int px2sp(int pxValue) {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5);
    }

}
