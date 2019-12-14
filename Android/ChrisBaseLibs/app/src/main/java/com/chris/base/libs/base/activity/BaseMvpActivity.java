package com.chris.base.libs.base.activity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.chris.base.libs.base.mvp.BasePresenter;


/**
 * com.alg.ailigouapp.library.base
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 13:12
 * Explain:
 */

public abstract class BaseMvpActivity extends BaseActivity {
    protected int pager = 0;

    @Override
    protected void afterContentView() {
        if (getPresenter() != null) {
            getPresenter().bindView(this);
        }
        super.initBase();
    }

    /**
     * 获取创建好的presenter
     *
     * @return
     */
    protected abstract BasePresenter getPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (getPresenter() != null) {
            getPresenter().unbindView();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("pager", pager);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.get("pager") == null) {
            pager = 0;
        } else {
            pager = (int) savedInstanceState.get("pager");
        }

    }

    public void showLoading() {

    }

    ;

    public void dismissLoading() {

    }
}
