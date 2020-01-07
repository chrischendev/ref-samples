package com.chris.vertx.client;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientResponse;
import io.vertx.ext.web.client.HttpResponse;
import io.vertx.ext.web.client.WebClient;

/**
 * Create by Chris Chan
 * Create on 2020/1/7 7:58
 * Use for: 主要目的是想在Android上面测试
 */
public class VertXClient {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpClient httpClient = vertx.createHttpClient();
        WebClient webClient = WebClient.create(vertx);

        test02(httpClient);
        //test04(webClient);


    }

    /**
     * 测试成功
     *
     * @param webClient
     */
    private static void test05(WebClient webClient) {

        webClient.get(7002, "http://192.168.0.100", "/user/getUserByName")
                .addQueryParam("name", "YaoShihan")
                .send(httpResponseAsyncResult -> System.out.println(httpResponseAsyncResult.result().body().toJson()));

    }

    /**
     * 测试成功
     *
     * @param webClient
     */
    private static void test04(WebClient webClient) {
        webClient.getAbs("http://192.168.0.100:7002/user/getUser").send(new Handler<AsyncResult<HttpResponse<Buffer>>>() {
            @Override
            public void handle(AsyncResult<HttpResponse<Buffer>> httpResponseAsyncResult) {
                System.out.println(httpResponseAsyncResult.result().body().toJson());
            }
        });

    }

    /**
     * 测试成功
     *
     * @param webClient
     */
    private static void test03(WebClient webClient) {
        webClient.getAbs("http://localhost:7002/user/login").send(new Handler<AsyncResult<HttpResponse<Buffer>>>() {
            @Override
            public void handle(AsyncResult<HttpResponse<Buffer>> httpResponseAsyncResult) {
                System.out.println(httpResponseAsyncResult.result().body().toString());
            }
        });

    }

    /**
     * 测试成功
     * @param httpClient
     */
    private static void test02(HttpClient httpClient) {
        httpClient.getNow(7002,"192.168.0.100","/user/login", new Handler<HttpClientResponse>() {
            @Override
            public void handle(HttpClientResponse httpClientResponse) {
                System.out.println(httpClientResponse.statusCode());
                httpClientResponse.handler(new Handler<Buffer>() {
                    @Override
                    public void handle(Buffer buffer) {
                        System.out.println(buffer.toString());
                    }
                });
            }
        });
    }

    /**
     * 测试成功
     *
     * @param httpClient
     */
    private static void test01(HttpClient httpClient) {
        httpClient.getNow("www.baidu.com", "/", response -> response.handler(new Handler<Buffer>() {
            @Override
            public void handle(Buffer buffer) {
                System.out.println(buffer.toString());
            }
        }));
    }
}
