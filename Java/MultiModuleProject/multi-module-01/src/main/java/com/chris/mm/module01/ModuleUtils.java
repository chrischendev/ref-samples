package com.chris.mm.module01;

import com.chris.mm.base.libs.UserModel;

/**
 * @author chrischan
 * create on 2019\7\17 0017 9:29
 * use for:
 */
public class ModuleUtils {
    public static void show() {
        System.out.println("I am module 01.");
    }

    public static UserModel getUser() {
        return new UserModel("kaly", 42);
    }
}
