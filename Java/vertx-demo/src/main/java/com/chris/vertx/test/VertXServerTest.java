package com.chris.vertx.test;

import com.chris.vertx.model.UserModel;
import com.google.gson.Gson;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;

/**
 * Create by Chris Chan
 * Create on 2020/1/7 7:35
 * Use for: 练习
 */
public class VertXServerTest {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        HttpServerOptions httpServerOptions = new HttpServerOptions();
        httpServerOptions
                .setPort(7001)
                .setMaxWebsocketFrameSize(1000000);

        //创建服务器
        HttpServer httpServer = vertx.createHttpServer(httpServerOptions);
        //请求数据处理
        httpServer.requestHandler(httpServerRequest -> {
            System.out.println(httpServerRequest.path());
            System.out.println(httpServerRequest.getClass().getName());
            HttpServerResponse response = httpServerRequest.response();
            response.putHeader("Content-Type", "application/json;charset=utf-8");
            response.end(gson.toJson(UserModel.create("kaly", 32)));
        });
        //启动服务器监听
        httpServer.listen(httpServerAsyncResult -> {
            if (httpServerAsyncResult.succeeded()) {
                System.out.println("程序正在监听");
            } else {
                System.out.println("程序启动监听失败");
            }
        });
    }
}
