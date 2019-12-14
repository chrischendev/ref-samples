package com.chris.security.config.filter;

import com.chris.security.consts.AppConstants;
import com.chris.security.utils.JWTUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * create by: Chris Chan
 * create on: 2019/9/27 10:38
 * use for:
 */
public class JWTAuthenticationFilter extends BasicAuthenticationFilter {
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取头部Authorization信息
        String token = request.getHeader(AppConstants.KEY_AUTHORIZATION);
        //如果没找到湖综合不是Bearer开头就放到下一个过滤器处理，比如登录接口就不带
        if (StringUtils.isEmpty(token) || !token.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }
        //创建验证信息
        UsernamePasswordAuthenticationToken authenlication = createAuthenlication(request);
        //放入上下文进行验证
        SecurityContextHolder.getContext().setAuthentication(authenlication);
        chain.doFilter(request, response);
    }

    /**
     * 创建身份验证信息
     * @param request
     * @return
     */
    private UsernamePasswordAuthenticationToken createAuthenlication(HttpServletRequest request) {
        String token = request.getHeader(AppConstants.KEY_AUTHORIZATION);
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        String username = String.valueOf(JWTUtils.getUsernameFromToken(token));
        if (!StringUtils.isEmpty(username)) {
            return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
        }
        return null;
    }
}
