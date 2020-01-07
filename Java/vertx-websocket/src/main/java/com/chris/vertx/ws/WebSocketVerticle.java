package com.chris.vertx.ws;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.ServerWebSocket;
import io.vertx.core.http.impl.ServerWebSocketImpl;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by Chris Chan
 * Create on 2020/1/7 13:52
 * Use for:
 */
public class WebSocketVerticle extends AbstractVerticle {
    private static Vertx vertx;
    private Map<String, ServerWebSocket> linkMap = new HashMap<>(16);

    private WebSocketVerticle() {
    }

    public static Vertx run() {
        vertx = Vertx.vertx();
        WebSocketVerticle webSocketVerticle = new WebSocketVerticle();
        vertx.deployVerticle(webSocketVerticle);
        return vertx;
    }

    @Override
    public void start() throws Exception {
        HttpServer httpServer = vertx.createHttpServer();
        Router router = Router.router(vertx);
        //????不知道路径路由怎么设置，子路由有没有思路？？

        router.post("/ws/chat").handler(new Handler<RoutingContext>() {
            @Override
            public void handle(RoutingContext event) {
                System.out.println(event.request().path());
            }
        });
        webSocketMethod(httpServer);
        httpServer.requestHandler(router)
                .listen(7003, event -> System.out.println(event.succeeded() ? "WebSocket server listenning..." : "WebSocket server start failed."));
    }

    private void webSocketMethod(HttpServer httpServer) {
        Handler<ServerWebSocket> webSocketHandler = serverWebSocket -> {
            String linkedId = serverWebSocket.binaryHandlerID();
            if (!linkMap.containsKey(linkedId)) {
                linkMap.put(linkedId, serverWebSocket);
            }
            serverWebSocket.frameHandler(webSocketFrame -> {
                String textData = webSocketFrame.textData();
                //向连接到服务器的所有其他客户端发送消息
                linkMap.keySet().stream()
                        .filter(idKey -> !idKey.equals(linkedId))
                        .forEach(idKey -> linkMap.get(idKey).writeTextMessage(textData));
            });
        };

        httpServer.websocketHandler(webSocketHandler);
    }
}
