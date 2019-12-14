package com.chris.base.libs.utils;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

/**
 * Created by 海航
 * on 2017/8/31.
 * 此类或接口用于 edittext  的一些设置
 */

public class EdittextUtils {
    /**
     *
     * @param editText
     * @param lookPwd  true设置为密码输入框  false设置为可见输入框
     */
    public static void setTransformationMethod(EditText editText, boolean lookPwd){
        if (!lookPwd) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance()); //设置为密码输入框
        } else {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
    }

}
