package com.chris.sec.utils;

import com.chris.sec.consts.AppConstants;
import com.chris.sec.model.UserInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

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
     * @param userInfo
     * @return
     */
    public static String createJWTByLoginUser(UserInfo userInfo, String[] authorities) {
        //构建有效载荷有关用户信息的部分
        Map<String, Object> claimsMap = new HashMap<>(16);
        //目前把用户名存进去
        claimsMap.put("username", userInfo.getUsername());
        claimsMap.put("authorities", authorities);
        //构建JWT
        String token = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setClaims(claimsMap)
                .setSubject(userInfo.getUsername())
                .setExpiration(Date.from(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("+8"))))
                .signWith(SignatureAlgorithm.HS512, AppConstants.JWT_SECRET_KEY_NORMAL)
                .compact();
        return token;
    }

    /**
     * 解析token
     *
     * @param token
     * @return
     */
    public static Claims parseTokenForBearer(String token) {
        return Jwts.parser()
                .setSigningKey(AppConstants.JWT_SECRET_KEY_NORMAL)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
    }

    /**
     * 从token中解析出username
     *
     * @param token
     * @return
     */
    public static String getUsernameFromToken(String token) {
        Object usernameObj = parseTokenForBearer(token).get("username");
        return String.valueOf(usernameObj);
    }

    /**
     * 获取权限列表
     *
     * @param token
     * @return
     */
    public static String[] getAuthorityFromToken(String token) {
        Object obj = parseTokenForBearer(token).get("authorities");
        ArrayList<String> authoritiyList = (ArrayList<String>) obj;
        String[] authorities = new String[authoritiyList.size()];
        return authoritiyList.toArray(authorities);
    }

}
