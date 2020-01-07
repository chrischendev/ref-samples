package com.chris.vertx.server;

import com.chris.vertx.model.UserModel;
import com.google.gson.Gson;
import io.vertx.ext.web.RoutingContext;

/**
 * Create by Chris Chan
 * Create on 2020/1/7 7:09
 * Use for: 接口类
 */
public class UserApi {
    private static Gson gson = new Gson();

    public static void login(RoutingContext context) {
        context.response().end("Login success.");
    }

    public static void getUser(RoutingContext context) {
        context.response()
                .putHeader("Content-Type", "application/json;charset=utf-8")
                .end(gson.toJson(UserModel.create("kaly", 32)));
    }

    public static void getUserByName(RoutingContext context) {
        context.response()
                .putHeader("Content-Type", "application/json;charset=utf-8")
                .end(gson.toJson(UserModel.create(context.request().getParam("name"), 32)));
    }

}
