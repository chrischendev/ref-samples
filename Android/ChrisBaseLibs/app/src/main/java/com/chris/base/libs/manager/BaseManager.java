package com.chris.base.libs.manager;

import android.content.Context;

/**
 * com.alg.ailigouapp.library.manager
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 17:35
 * Explain:基本管理器
 */

public class BaseManager {
public static Context mContext;

    public static void init(Context context){
        mContext=context;
    }
}
