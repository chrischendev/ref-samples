package com.chris.base.libs.base.holder;

import android.view.View;

import butterknife.ButterKnife;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.base.holder
 * Created by Chris Chen on 2017/7/3 17:02.
 * Explain:holder基类，依赖于Butterknife
 */

public class BaseHolder {
    public View itemView;
    public BaseHolder(View itemView) {
        this.itemView=itemView;
        ButterKnife.bind(this,itemView);
    }
}
