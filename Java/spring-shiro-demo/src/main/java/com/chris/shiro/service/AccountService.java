package com.chris.shiro.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 17:24
 * use for:
 */
@Service
public class AccountService {
    @Autowired
    SecurityManager securityManager;

    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));

        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        String url = savedRequest.getRequestUrl();
        response.sendRedirect(url);//重新定向到登录前的URL

        return "Login success.";
    }
}
