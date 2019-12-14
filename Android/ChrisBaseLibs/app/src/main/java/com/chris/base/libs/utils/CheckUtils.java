package com.chris.base.libs.utils;

import com.chris.base.libs.consts.RegularExpression;
import com.chris.base.libs.manager.UtilsManager;

import java.util.regex.Pattern;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.utils
 * Created by Chris Chen on 2017/7/4 09:56.
 * Explain:输入内容验证工具类
 */

public class CheckUtils extends UtilsManager implements RegularExpression {
    /**
     * 验证正则表达式
     *
     * @param strExp
     * @param value
     * @return
     */
    public static boolean matches(String strExp, CharSequence value) {
        Pattern pattern = Pattern.compile(strExp);
        return pattern.matcher(value).matches();
    }

    /**
     * 验证是否为6位验证码
     *
     * @param value
     * @return
     */
    public static boolean isVerificationCode6(CharSequence value) {
        return matches(EXPRESSION_VERIFICATION_CODE_6, value);
    }

    /**
     * 验证是否为5位验证码
     *
     * @param value
     * @return
     */
    public static boolean isVerificationCode5(CharSequence value) {
        return matches(EXPRESSION_VERIFICATION_CODE_5, value);
    }

    /**
     * 判断是否为手机号码
     *
     * @param value
     * @return
     */
    public static boolean isMobliePhoneNumber(CharSequence value) {
        return matches(EXPRESSION_MOBLIE_PHONENUMBER, value);
    }

    /**
     * 判断是否为电子邮箱地址
     *
     * @param value
     * @return
     */
    public static boolean isEmailAddress(CharSequence value) {
        return matches(EXPRESSION_EMAIL, value);
    }

    /**
     * 判断是否为18位身份证号码
     *
     * @param value
     * @return
     */
    public static boolean isIdNumber18(CharSequence value) {
        return matches(EXPRESSION_ID_18, value);
    }

    /**
     * 判断6-15密码
     */
    public static boolean isPWD_6_15(CharSequence value) {
        return matches(EXPRESSION_PWD_6_15, value);
    }
}
