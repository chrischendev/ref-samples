package com.chris.ws.config;

import com.chris.ws.model.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Map;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 11:05
 * Use for: 处理websocket请求，这里我们只重写determineUser方法，生成我们自己的Principal ，这里我们使用username标记登录用户，而不是默认值
 */
@Component
public class ChatPrincipalHandshakeHandler extends DefaultHandshakeHandler {
    private static final Logger log = LoggerFactory.getLogger(ChatPrincipalHandshakeHandler.class);

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        HttpSession httpSession = SessionUtils.getSession(request);
        if (null == httpSession) {
            return () -> SessionUtils.GUEST;
        }
        String username = (String) httpSession.getAttribute(SessionUtils.USERNAME);

        if (StringUtils.isEmpty(username)) {
            log.error("Not login!");
            return () -> SessionUtils.GUEST;
        }
        log.info(" MyDefaultHandshakeHandler login = " + username);
        return new LoginInfo(username);
    }

}
