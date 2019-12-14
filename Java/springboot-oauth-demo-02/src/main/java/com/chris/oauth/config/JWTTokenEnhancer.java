package com.chris.oauth.config;

import com.chris.oauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * create by: Chris Chan
 * create on: 2019/10/12 12:39
 * use for: JWT扩展处理
 */
@Component
@Primary
public class JWTTokenEnhancer implements TokenEnhancer {
    @Autowired
    UserService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        //添加附加信息
        Map<String, Object> map = new HashMap<>(16);
        map.put("additional", userService.getUserAdditional(username));
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(map);
        //设置过期时间
        ((DefaultOAuth2AccessToken) accessToken).setExpiration(new Date(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        return accessToken;
    }
}
