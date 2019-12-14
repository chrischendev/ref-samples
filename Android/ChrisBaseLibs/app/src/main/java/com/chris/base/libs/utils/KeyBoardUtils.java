package com.chris.base.libs.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by 海航
 * on 2017/8/3.
 * 此类或接口用于
 */

public class KeyBoardUtils {
    //隐藏键盘
    public static void HideKeyboard(View view, Activity activity) {
        InputMethodManager systemService = (InputMethodManager) activity.getSystemService(INPUT_METHOD_SERVICE);
        systemService.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    //自动弹出键盘
    public static void openKeyBoard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }
}
