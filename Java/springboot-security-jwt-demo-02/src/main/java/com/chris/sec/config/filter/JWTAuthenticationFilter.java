package com.chris.sec.config.filter;

import com.chris.sec.consts.AppConstants;
import com.chris.sec.service.UserService;
import com.chris.sec.utils.JWTUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        //除非是登录，否则Authorization头信息必须要有，没有就抛异常
        StringBuffer requestURL = request.getRequestURL();
        if (requestURL.toString().contains("/api/user/login")) {
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
     *
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
            return new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.createAuthorityList(JWTUtils.getAuthorityFromToken(token)));
        }
        return null;
    }
}
