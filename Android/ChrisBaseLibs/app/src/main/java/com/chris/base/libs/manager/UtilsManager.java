package com.chris.base.libs.manager;

import android.content.Context;

/**
 * com.alg.ailigouapp.library.manager
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 15:16
 * Explain:工具类管理器
 */

public class UtilsManager {
    public static Context mContext;

    public static void init(Context context) {
        UtilsManager.mContext = context;
    }
}
