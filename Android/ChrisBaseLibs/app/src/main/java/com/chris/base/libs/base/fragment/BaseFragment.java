package com.chris.base.libs.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chris.base.libs.base.activity.BaseActivity;
import com.chris.base.libs.net.NetManager;
import com.hwangjr.rxbus.Bus;
import com.hwangjr.rxbus.RxBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.base
 * Created by Chris Chen on 2017/7/3 15:16.
 * Explain:基本Fragment
 */

public abstract class BaseFragment extends Fragment {
    protected Context context;
    public View contentView;
    protected Bus bus;
    private Unbinder unbinder;

    protected boolean isCreate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(layoutId(), container, false);
        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        createViewHolder(view);
        initBase();
        initInjector();
        super.onViewCreated(view, savedInstanceState);
        afterContentView();
        initViewAndListener();
        isCreate = true;
    }

    /**
     * 是否创建一个页面数据持有者
     *
     * @return
     */
    protected void createViewHolder(View contentView) {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        initRxBus();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void initRxBus() {
        if (hasBus()) {
            if (bus == null) {
                bus = RxBus.get();
                bus.register(this);
            } else {
                bus.register(this);
            }
        }
    }

    protected boolean hasBus() {
        return false;
    }

    @Override
    public void onStop() {
        super.onStop();
        isCreate = false;
    }

    @Override
    public void onDestroy() {

        if (hasBus()) {
            if (bus != null) {
                bus.unregister(this);
            }
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
        NetManager.removeAllRequest();
        super.onDestroy();
    }

    public Context getBaseContext() {
        return this.context;
    }

    /**
     * 创建页面布局之后的处理
     */
    protected abstract void afterContentView();


    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    protected void initBase() {

    }

    protected void initInjector() {

    }

    protected void initViewAndListener() {

    }

    public View getContentView() {
        return contentView;
    }

    /**
     * 布局文件资源ID
     *
     * @return
     */
    protected abstract int layoutId();

    /**
     * 跳转到其他的Activity
     *
     * @param clazz
     */
    protected void startActivity(Class clazz) {
        Intent intent = new Intent(getContext(), clazz);
        startActivity(intent);
    }
}
