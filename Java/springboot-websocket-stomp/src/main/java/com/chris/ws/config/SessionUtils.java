package com.chris.ws.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;

import javax.servlet.http.HttpSession;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 11:57
 * Use for:
 */
public class SessionUtils {
    public static final String USERNAME = "username";
    public static final String GUEST = "guest";//没有登录的用户构建为来宾用户

    /**
     * request中获取 session
     *
     * @param request
     * @return
     */
    public static HttpSession getSession(ServerHttpRequest request) {
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest serverRequest = (ServletServerHttpRequest) request;
            return serverRequest.getServletRequest().getSession(false);
        }
        return null;
    }

}
