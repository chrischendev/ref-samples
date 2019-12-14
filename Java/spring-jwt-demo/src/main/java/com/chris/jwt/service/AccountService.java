package com.chris.jwt.service;

import com.chris.jwt.model.User;
import com.chris.jwt.utils.TokenUtils;
import org.springframework.stereotype.Service;

/**
 * @author chrischan
 * create on 2019/6/24 9:25
 * use for:
 */
@Service
public class AccountService {

    public Object login(String username, String password) {

        User user = User.create(1, username, password, "ROLE_ADMIN", "ROLE_USER");

        String sub = "jwt_test";

        //构建的时候把用户信息中的用户名
        return TokenUtils.build(user, sub, 600000, "username","permissions");
    }

    public String parseToken(String token, String field) {
        return String.valueOf(TokenUtils.parse(token).get(field));
    }

}
