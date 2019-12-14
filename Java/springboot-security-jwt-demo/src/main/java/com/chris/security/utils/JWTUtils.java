package com.chris.security.utils;

import com.chris.security.consts.AppConstants;
import com.chris.security.model.LoginUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * create by: Chris Chan
 * create on: 2019/9/27 13:02
 * use for: JWT处理工具
 */
public class JWTUtils {
    /**
     * 通过User对象构建jwt
     * 此处是专用的
     *
     * @param user
     * @return
     */
    public static String createJWTByLoginUser(LoginUser user) {
        //构建有效载荷有关用户信息的部分
        Map<String, Object> claimsMap = new HashMap<>(16);
        //目前把用户名存进去
        claimsMap.put("username", user.getUsername());
        //构建JWT
        String token = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setClaims(claimsMap)
                .setSubject(user.getUsername())
                .setExpiration(Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("+8"))))
                .signWith(SignatureAlgorithm.HS512, AppConstants.JWT_SECRET_KEY_NORMAL)
                .compact();
        return token;
    }

    /**
     * 从token中解析出username
     *
     * @param token
     * @return
     */
    public static String getUsernameFromToken(String token) {
        Object usernameObj = Jwts.parser()
                .setSigningKey(AppConstants.JWT_SECRET_KEY_NORMAL)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody()
                .get("username");//因为我们在这里放置了用户名 可以自由处理
        return String.valueOf(usernameObj);
    }
}
