package com.chris.ws.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 10:44
 * Use for:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //password随便，此处不做验证。把username写入session，用以区别用户
        session.setAttribute("username", username);

        return username + " login success.";
    }
}
