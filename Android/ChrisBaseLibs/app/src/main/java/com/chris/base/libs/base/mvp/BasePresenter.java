package com.chris.base.libs.base.mvp;

/**
 * com.alg.ailigouapp.library.mvp
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 11:49
 * Explain:MVP-Presenter
 */

public interface BasePresenter<View> {
    /**
     * 绑定View
     * @param view
     */
    void bindView(View view);

    /**
     * 解除绑定
     */
    void unbindView();
}
