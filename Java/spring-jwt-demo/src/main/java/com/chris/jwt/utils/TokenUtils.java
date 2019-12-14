package com.chris.jwt.utils;

import com.chris.jwt.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author chrischan
 * create on 2019/6/24 9:48
 * use for:
 */
public class TokenUtils {
    /**
     * 指纹 最关键的东西 不可丢失
     */
    private static String secret = "ASFW56868UIIGNJ2356SKFH568DS856876FJK";

    /**
     * 工具初始化
     *
     * @param secret
     */
    public static void init(String secret) {
        //设置一个通用指纹 出入保持一致
        TokenUtils.secret = secret;
    }

    /**
     * 构建token 使用公用的指纹
     *
     * @param obj
     * @param subject
     * @param ttMillis
     * @param fieldNames
     * @param <T>
     * @return
     */
    public static <T> String build(T obj, String subject, long ttMillis, String... fieldNames) {
        return build(obj, TokenUtils.secret, subject, ttMillis, fieldNames);
    }

    /**
     * 构建token
     *
     * @param obj        需要添加到token中的用户对象
     * @param secret     指纹
     * @param subject    主题
     * @param ttMillis   过期时间
     * @param fieldNames 需要添加到token中的字段
     * @param <T>
     * @return
     */
    public static <T> String build(T obj, String secret, String subject, long ttMillis, String... fieldNames) {
        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成token的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //私有生命 最有用的部分 可携带信息
        Class<?> objClass = obj.getClass();
        Map<String, Object> claims = new HashMap<>(16);
        for (String fieldName : fieldNames) {
            Field field = null;
            try {
                field = objClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(obj);
                field.setAccessible(false);
                claims.put(fieldName, value);
            } catch (Exception e) {
                continue;
            }
        }

        //构建
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuer("chris") //签发人
                .setIssuedAt(now) //签发时间
                .setSubject(subject) //主题
                .signWith(signatureAlgorithm, secret);
        //添加过期时间
        if (ttMillis > 0) {
            long expMillis = nowMillis + ttMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    /**
     * 解析token 使用通用指纹
     *
     * @param tokenJson
     * @return
     */
    public static Claims parse(String tokenJson) {
        return parse(tokenJson, secret);
    }

    /**
     * 解析token 使用自定义指纹
     *
     * @param tokenJson
     * @param secret
     * @return
     */
    public static Claims parse(String tokenJson, String secret) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(tokenJson).getBody();
        return claims;
    }

    /**
     * token是否有效检查
     * 此处只对user做简单密码匹配校验
     *
     * @param tokenJson
     * @param user
     * @return
     */
    public static boolean isEffective(String tokenJson, User user) {
        String password = user.getPassword();
        Claims claims = parse(tokenJson, secret);
        //todo 检查过期
        Object password1 = claims.get("password");

        if (null != password1 && password.equals(password1)) {
            return true;
        }
        return false;
    }
}
