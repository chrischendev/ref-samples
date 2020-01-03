package com.chris.ws.model;

import java.security.Principal;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 10:55
 * Use for: 登录信息
 */
public class LoginInfo implements Principal {
    private String username;

    public LoginInfo(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return username;
    }
}
