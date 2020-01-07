package com.chris.vertx.server;

import io.vertx.ext.web.Router;

/**
 * Create by Chris Chan
 * Create on 2020/1/7 7:27
 * Use for:
 */
public class RouterCenter {
    public static void set(Router router) {
        router.get("/api/test").handler(context -> VertXServer.test(context));//方式1
        router.get("/user/login").handler(UserApi::login);//方式2
        router.get("/user/getUser").handler(UserApi::getUser);
        router.get("/user/getUserByName").handler(UserApi::getUserByName);
    }
}
