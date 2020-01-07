package com.chris.vertx.server;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;

/**
 * Create by Chris Chan
 * Create on 2020/1/7 7:00
 * Use for: Vert.x服务器
 */
public class VertXServer extends AbstractVerticle {
    private Vertx vertx;

    private VertXServer(Vertx vertx) {
        this.vertx = vertx;
    }

    public static void run() {
        Vertx vertx = Vertx.vertx();
        VertXServer vertXServer = new VertXServer(vertx);
        vertx.deployVerticle(vertXServer);
    }

    @Override
    public void start(Future<Void> startFuture) throws Exception {
        HttpServer httpServer = vertx.createHttpServer();
        Router router = Router.router(vertx);
        CorsHandler corsHandler = CorsHandler.create("*")
                .allowedMethod(HttpMethod.GET)
                .allowedMethod(HttpMethod.POST)
                .allowedHeader("Content-Type");
        BodyHandler bodyHandler = BodyHandler.create();
        router.route()
                .handler(corsHandler)//跨域处理
                .handler(bodyHandler);//body支持
        //接口路由
        RouterCenter.set(router);

        httpServer.requestHandler(router).listen(7002, httpServerAsyncResult -> {
            if (httpServerAsyncResult.succeeded()) {
                System.out.println("Application is listenning...");
            } else {
                System.out.println("Application start failed.");
            }
        });
    }

    @Override
    public Vertx getVertx() {
        return vertx;
    }

    public static void test(RoutingContext context) {
        context.response().end("test ok.");
    }
}
