package com.chris.security.service;

import com.chris.security.config.AppManager;
import com.chris.security.consts.AppConstants;
import com.chris.security.model.LoginUser;
import com.chris.security.model.User;
import com.chris.security.utils.JWTUtils;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * create by: Chris Chan
 * create on: 2019/9/26 8:15
 * use for:
 */
@Service
public class UserService implements UserDetailsService {
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 自定义Basic方式登录
     * 涉及上次面试题
     *
     * @param request
     * @param response
     * @return
     */
    public String loginBasic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从头部取得数据
        String authToken = request.getHeader(AppConstants.KEY_AUTHORIZATION);
        if (StringUtils.isEmpty(authToken) || !authToken.startsWith("Basic ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
        //解析
        String loginInfo = TextCodec.BASE64URL.decodeToString(authToken.replace("Basic ", ""));
        String[] split = loginInfo.split(":");
        if (split.length != 2) {
            throw new RuntimeException("token格式不正确");
        }
        String username = split[0];
        String password = split[1];

        System.out.println(username + " : " + password);
        return login(new LoginUser(username, password), response);
    }

    /**
     * 自定义登录
     *
     * @param loginUser
     * @param response
     * @return
     */
    public String login(LoginUser loginUser, HttpServletResponse response) throws IOException {
        User user = findUser(loginUser.getUsername());
        //测试 上一次面试相关 如果没找到用户 抛401
        if (null == user) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        //如果密码不匹配 抛403
        if (!passwordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null;
        }

        return JWTUtils.createJWTByLoginUser(loginUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        User user = findUser(username);
        if (null == user) {
            return null;
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    /**
     * 查找用户
     *
     * @param username
     * @return
     */
    private User findUser(String username) {
        for (User user : AppManager.userList) {
            if (username.equalsIgnoreCase(user.getUsername())) {
                return user;
            }
        }
        return null;
    }
}
