package com.chris.base.libs.base.application;

import android.app.Application;

/**
 * com.alg.ailigouapp.library.base
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 10:27
 * Explain:
 */

public abstract class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    protected abstract void init() ;
}
