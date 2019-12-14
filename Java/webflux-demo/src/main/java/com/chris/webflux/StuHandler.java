package com.chris.webflux;

import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * create by: Chris Chan
 * create on: 2019/12/4 11:54
 * use for:
 */
public class StuHandler {
    //??怎么加入自定义的业务？返回没有数据
    public static Mono<ServerResponse> getStu(ServerRequest request) {
        Stu stuBody = new Stu();
        request.bodyToMono(Stu.class)
                .subscribe(
                        stu -> BeanUtils.copyProperties(stu, stuBody)
                );
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(stuBody));
    }

    public static Mono<ServerResponse> addStu(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("add stu success"));
    }
}
