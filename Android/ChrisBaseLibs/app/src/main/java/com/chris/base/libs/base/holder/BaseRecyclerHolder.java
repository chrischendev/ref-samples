package com.chris.base.libs.base.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.base.holder
 * Created by Chris Chen on 2017/7/3 17:19.
 * Explain:RecyclerView.ViewHolder的封装基类，依赖于Butterknife
 */

public class BaseRecyclerHolder extends RecyclerView.ViewHolder {
    protected View itemView;
    public BaseRecyclerHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;
        ButterKnife.bind(this,itemView);
    }
}
