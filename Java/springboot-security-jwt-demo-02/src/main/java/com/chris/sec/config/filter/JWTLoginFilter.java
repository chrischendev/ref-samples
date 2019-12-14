package com.chris.sec.config.filter;

import com.chris.sec.model.UserInfo;
import com.chris.sec.service.UserService;
import com.chris.sec.utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * create by: Chris Chan
 * create on: 2019/9/26 11:43
 * use for: 自动登录处理 接收并解析用户信息
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            //从权限认证信息中心读取用户名和密码
            UserInfo userInfo = new ObjectMapper().readerFor(UserInfo.class).readValue(request.getInputStream());
            //创建身份验证token
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userInfo.getUsername(), userInfo.getPassword(), Collections.emptyList());
            //创建用户身份验证信息
            Authentication authenticate = authenticationManager.authenticate(token);
            return authenticate;
        } catch (IOException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        //super.successfulAuthentication(request, response, chain, authResult);
        //如果验证通过就创建token返回

        //获取用户信息
        User user = (User) authResult.getPrincipal();
        //构建jwt
        String username = user.getUsername();
        String token = JWTUtils.createJWTByLoginUser(new UserInfo(username, user.getPassword()), UserService.getAuthorities(username));
        //把JWT添加到响应头
        response.addHeader("Authorization", "Bearer " + token);
    }
}
