package com.chris.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 5:54
 * Use for: WebSocket配置文件
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Autowired
    AuthHandshakeInterceptor authHandshakeInterceptor;
    @Autowired
    ChatPrincipalHandshakeHandler chatPrincipalHandshakeHandler;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry
                .addEndpoint("/chat")
                .setAllowedOrigins("*")//设置跨域
                .addInterceptors(authHandshakeInterceptor)//websocket连接前检查登录
                .setHandshakeHandler(chatPrincipalHandshakeHandler)//构建用户角色
                .withSockJS();//支持JS
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
