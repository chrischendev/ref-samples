package com.chris.base.libs.consts;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.consts
 * Created by Chris Chen on 2017/7/4 13:48.
 * Explain:正则表达式
 */

public interface RegularExpression {
    //18位身份证
    String EXPRESSION_ID_18 = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$";
    //6位验证码
    String EXPRESSION_VERIFICATION_CODE_6 = "^[0-9]{6}$";
    String EXPRESSION_VERIFICATION_CODE_5 = "^[0-9]{5}$";
    //电话号码
    String EXPRESSION_PHONENUMBER = "\\d{3}-\\d{8}|\\d{4}-\\{7,8}";
    //手机号码
    String EXPRESSION_MOBLIE_PHONENUMBER = "^1[34578]\\d{9}$";
    //固话号码
    String EXPRESSION_FIX_PHONENUMBER = "^d{4}[0-9]{7,8}$";
    //网址
    String EXPRESSION_URL = "[a-zA-z]+://[^\\s]*";
    //电子邮箱
    String EXPRESSION_EMAIL = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
    //QQ
    String EXPRESSION_QQ = "[1-9][0-9]{4,}";
    //QQ
    String EXPRESSION_ZIP_CODE = "[1-9]\\d{5}(?!\\d)";
     //6到15位密码
    String EXPRESSION_PWD_6_15 = "^[0-9a-zA-Z_#]{6,15}$";
}
