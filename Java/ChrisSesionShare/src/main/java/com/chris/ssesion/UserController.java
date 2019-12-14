package com.chris.ssesion;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * ChrisSesionShare
 * com.chris.ssesion
 * Created by Chris Chen
 * 2018/8/21
 * Explain:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        if (token == null) {
            token = UUID.randomUUID().toString();
            String m = "没有登陆过，生成新的token: " + token;
            System.out.println(m);
            session.setAttribute("token", token);
            response.setHeader("token", token);
            return m;
        } else {
            String m = "已经登陆过，token: " + token;
            return m;
        }
    }

    @RequestMapping("/get")
    public String get(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        String token1 = request.getHeader("token");
        String msg = "";
        if (token.equals(token1)) {
            msg = "身份合法，token：" + token;
        } else {
            msg = "身份不合法，请重新登录,你发送的token：" + token1;
        }
        System.out.println(msg);
        return msg;
    }
}
