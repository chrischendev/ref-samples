package com.chris.vertx.ws;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.WebSocket;

/**
 * Create by Chris Chan
 * Create on 2020/1/8 2:36
 * Use for:
 */
public class WebSocketVertXClient {
    private static WebSocket webSocket;

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpClient httpClient = vertx.createHttpClient();
        httpClient.webSocket(7003, "192.168.0.100", "/", event -> {
            System.out.println("连接成功");
            WebSocket webSocket = event.result();
            WebSocketVertXClient.webSocket = webSocket;
            //读取
            webSocket.frameHandler(webSocketFrame -> System.out.println(webSocketFrame.textData()));
            //写入
            webSocket.writeFinalTextFrame("Hello!f");
            System.out.println("1 "+Thread.currentThread().getName());
        });
        System.out.println("2 "+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (null!=WebSocketVertXClient.webSocket) {
            WebSocketVertXClient.webSocket.writeTextMessage("呵呵");
        }
    }

}
