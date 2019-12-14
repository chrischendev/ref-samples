package com.chris.session.api;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * com.chris.ssesion
 * Created by Chris Chen
 * 2018/8/21
 * Explain:
 */
@RestController
@RequestMapping("/user")
public class SessionController {
    @RequestMapping("/login")
    public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        String msg = null;
        if (token == null) {
            msg = "没有登陆过，生成新的token: " + token;
            System.out.println(msg);
            session.setAttribute("token", token);
            response.setHeader("token", token);
        } else {
            msg = "已经登陆过，token: " + token;
        }
        return ResponseEntity.ok().header("token", token).body(msg);
    }

    @RequestMapping("/get")
    public ResponseEntity<?> get(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        String token1 = request.getHeader("token");
        String msg = "";
        if (!StringUtils.isEmpty(token) && token.equals(token1)) {
            msg = "身份合法，token：" + token;
        } else {
            msg = "身份不合法，请重新登录,你发送的token：" + token1;
        }
        System.out.println(msg);
        return ResponseEntity.ok().header("token", token).body(msg);
    }
}
