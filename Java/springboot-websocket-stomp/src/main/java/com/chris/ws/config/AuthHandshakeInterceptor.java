package com.chris.ws.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 11:55
 * Use for: WebSocket握手请求的拦截器
 * 在websocket握手前判断，判断当前用户是否已经登录。如果未登录，则不允许登录websocket
 */
@Component
public class AuthHandshakeInterceptor implements HandshakeInterceptor {
    private static final Logger log = LoggerFactory.getLogger(AuthHandshakeInterceptor.class);

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        HttpSession httpSession = SessionUtils.getSession(request);
        if (null == httpSession) {
            log.error("No login,can not connect websocket!");
            response.getBody().write("connect failed.".getBytes());
            return false;
        }
        String username = (String) httpSession.getAttribute(SessionUtils.USERNAME);

        if (StringUtils.isEmpty(username)) {
            log.error("No login,can not connect websocket2!");
            return false;
        }
        log.info("login user: " + username);

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
    }
}
