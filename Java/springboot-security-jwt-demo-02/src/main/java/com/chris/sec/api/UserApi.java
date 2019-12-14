package com.chris.sec.api;

import com.chris.sec.model.UserInfo;
import com.chris.sec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by: Chris Chan
 * create on: 2019/9/26 7:59
 * use for:
 */
@RestController
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserInfo userInfo, HttpServletResponse response) throws IOException {
        String token = userService.login(userInfo, response);
        return token;
    }

    /**
     * basic登录
     * 涉及上次的面试题
     * 登录信息不在参数中，而在头部信息的Authrication中，以Basic 开头，用户名和密码用冒号连接，并做过Base64编码
     *
     * @return
     */
    @PostMapping("/loginBasic")
    public String loginBasic(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return userService.loginBasic(request, response);
    }
}
