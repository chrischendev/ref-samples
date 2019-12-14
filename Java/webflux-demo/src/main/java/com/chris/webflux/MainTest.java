package com.chris.webflux;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.ipc.netty.http.server.HttpServer;

import java.io.IOException;

/**
 * create by: Chris Chan
 * create on: 2019/12/4 11:35
 * use for: 主测试类
 * 不用传统的启动方式，在这里启动即可
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebFluxConfig.class);

        //HttpHandler httpHandler = WebHttpHandlerBuilder.applicationContext(context).build();
        HttpHandler httpHandler = RouterFunctions.toHttpHandler(
                RouterFunctions.route(RequestPredicates.GET("/getStu").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), StuHandler::getStu)
                        .and(RouterFunctions.route(RequestPredicates.GET("/addStu").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), StuHandler::addStu))
        );

        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer.create("localhost", 8023).newHandler(httpHandlerAdapter).block();
        System.in.read();
    }
}
