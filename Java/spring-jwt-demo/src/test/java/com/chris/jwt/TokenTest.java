package com.chris.jwt;

import com.chris.jwt.model.User;
import com.chris.jwt.utils.TokenUtils;
import io.jsonwebtoken.Claims;

/**
 * @author chrischan
 * create on 2019/6/24 10:50
 * use for:
 */
public class TokenTest {
    public static void main(String[] args) {
//        testTokenUtils();
        test1();
//        test2();
    }

    /**
     * 测试校验
     */
    private static void test2() {
        User user = new User(1, "chris", "123456", new String[]{"user.add", "user.delete"});
        boolean effective = TokenUtils.isEffective("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaHJpc2NoZW4iLCJwYXNzd29yZCI6IjEyMzQ1NiIsInBlcm1pc3Npb25zIjpbInVzZXIuYWRkIiwidXNlci5kZWxldGUiXSwibmFtZSI6ImNocmlzIiwiZXhwIjoxNTYxMzU4NjY2LCJpYXQiOjE1NjEzNTg2MDYsImp0aSI6IjFjYmM2MGM3LTZmODctNDVhYy04MzYwLWFiZDc5ZjQ4OTA4YSJ9.y4PgvN-vUdxhXgXCsvXD74WurT1ZOZJZzaJJsXiqKdE", user);
        System.out.println(effective);
    }

    /**
     * 测试解析
     */
    private static void test1() {
        Claims claims = TokenUtils.parse("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaHJpcyIsInBlcm1pc3Npb25zIjpbInVzZXIuYWRkIiwidXNlci5kZWxldGUiXSwibmFtZSI6ImNocmlzIiwiaWQiOjEsImV4cCI6MTU2MTM0NjM4OSwiaWF0IjoxNTYxMzQ2MzI5LCJhZ2UiOiIxMjM0NTYiLCJqdGkiOiI3OTBhNDY1ZC1iYmQzLTRiMjMtYjk2OC05NGUzZjAxYWIyMmEifQ.lnWSIlvZlPD5wEccIWC3bF4LRUeGepQJl1jifkHfPS0", "ASFW56868UIIGNJ2356SKFH568DS856876FJK");
        String name = String.valueOf(claims.get("username"));
        System.out.println(name);
    }

    /**
     * 测试构建
     */
    private static void testTokenUtils() {
        User user = new User(1, "chris", "123456", new String[]{"user.add", "user.delete"});
        String token = TokenUtils.build(user, "chrischen", 1000 * 60, "username", "password","permissions");
        System.out.println(token);
    }
}
