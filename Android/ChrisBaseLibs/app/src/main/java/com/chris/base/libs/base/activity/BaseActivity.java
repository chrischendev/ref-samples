package com.chris.base.libs.base.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.chris.base.libs.R;
import com.chris.base.libs.manager.WinManager;
import com.chris.base.libs.net.NetManager;
import com.chris.base.libs.utils.StatusBarUtil;
import com.hwangjr.rxbus.Bus;
import com.hwangjr.rxbus.RxBus;

import java.io.Serializable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * com.alg.ailigouapp.library.base
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 10:48
 * Explain:
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;
    protected Bus bus;
    protected boolean isCreated;
    private View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeContentView();
        initBase();
        initInjector();
        contentView = getLayoutInflater().inflate(layoutId(), null);
        //contentView.setPadding(0, ScreenUtils.getStatueBarHeight(),0,0);
        setContentView(contentView);
        initBus();
        unbinder = ButterKnife.bind(this);
        createViewHolder(contentView);
        //状态栏沉浸式处理
        initStatueBar();
        afterContentView();
        initViewAndListener();
        WinManager.get().addActivity(this);//将Activity添加到堆栈
        isCreated = true;
    }

    /**
     * 是否创建一个页面数据持有者
     * @param view
     */
    protected void createViewHolder(View view) {
    }

    /**
     * 创建页面布局之后的处理对contentView的相关处理，属针对contentView的预留方法
     */
    protected abstract void afterContentView();

    /**
     * 对状态栏做沉浸式处理
     */
    protected void initStatueBar() {
//        if (hasImmersive()) {
//            if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    /*
//                    如果复写了activityThemeColor()方法，并且返回一个合法的颜色，
//                    界面将会用这个颜色填充状态栏背景，不做沉浸式处理
//                     */
//                    if (activityThemeColor() != 0) {
//                        getWindow().setStatusBarColor(activityThemeColor());
//                    } else {
//                        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//                        getWindow().setStatusBarColor(Color.TRANSPARENT);
//                    }
//                } else {
//                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//                }
//            }
//        }
        StatusBarUtil.setColor(this,activityThemeColor());
        if (activityThemeColor()== Color.WHITE||activityThemeColor()== Color.argb(00,255,255,255)){
            StatusBarUtil.setStatusWrite(this);
        }
    }

    /**
     * 设置界面主题颜色
     *
     * @return
     */
    protected int activityThemeColor() {
        return Color.WHITE;
    }

    void initBus() {
        if (hasBus()) {
            if (bus == null) {
                bus = RxBus.get();
                bus.register(this);
            }
        }
        if (isCreated) {
            //初始化
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (hasBus()) {
            if (bus != null) {
                bus.unregister(this);
            }
            unbinder.unbind();
            NetManager.removeAllRequest();
        }
    }

    public BaseActivity getBaseActivity() {
        return this;
    }

    /**
     * 是否需要RxBus
     *
     * @return
     */
    protected boolean hasBus() {
        return false;
    }

    /**
     * 是否需要沉浸式状态栏处理效果
     *
     * @return
     */
    protected boolean hasImmersive() {
        return true;
    }

    /**
     * 界面主布局
     *
     * @return
     */
    protected abstract int layoutId();

    /**
     * 初始化控件和监听器,一般的控件初始化、监听器初始化和网络请求都应该从这里开始
     */
    protected void initViewAndListener() {
    }

    /**
     * 基本初始化
     */
    protected void initBase() {
    }

    /**
     * 在setContentView()之前的操作
     */
    public void beforeContentView() {
    }

    /**
     * 初始化dagger2注入器
     */
    protected void initInjector() {

    }

    public View getContentView() {
        return contentView;
    }

    /**
     * 跳转到其他的Activity
     *
     * @param clazz
     */
    protected void startActivity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }

    @Override
    protected void onPause() {
        super.onPause();
        isCreated=false;
    }

    /**
     * 跳转到其他的Activity并且结束当前的Activity
     *
     * @param clazz
     */
    protected void startActivityAndFinished(Class clazz) {
        startActivity(clazz);
        finish();
    }

    /**
     * 跳转到其他的Activity并且携带数据
     *
     * @param clazz
     * @param key
     * @param value
     */
    protected void startActivityWithExtra(Class clazz, String key, Serializable value) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra(key, value);
        startActivity(intent);
    }

    /**
     * 携带数据跳转到其他的Activity，并且结束当前Activity
     *
     * @param clazz
     * @param key
     * @param value
     */
    protected void startActivityWithExtraAndFinished(Class clazz, String key, Serializable value) {
        startActivityWithExtra(clazz, key, value);
        finish();
    }

    /**
     * 通过Intent对象跳转到其他Activity，并且结束当前Activity
     *
     * @param intent
     */
    protected void startActivityIntentAndFinished(Intent intent) {
        startActivity(intent);
        finish();
    }

    /**
     * 跳转到其他Activity并处理返回结果
     *
     * @param clazz
     * @param requestCode
     */
    protected void startActivityForResult(Class clazz, int requestCode) {
        startActivityForResult(new Intent(this, clazz), requestCode);
    }

    /**
     * 跳转到其他Activity并处理返回结果
     *
     * @param clazz
     */
    protected void startActivityForResult(Class clazz) {
        startActivityForResult(new Intent(this, clazz), 0);
    }

}
