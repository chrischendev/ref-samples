package com.chris.shiro.config.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 21:48
 * use for: 自定义的filter
 */
public class MyRolesFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Subject subject = getSubject(servletRequest, servletResponse);
        String[] roles = (String[]) o;
        if (null == roles || roles.length == 0) {
            return true;
        }
        for (String role : roles) {
            //满足其中一个角色即可
            if (subject.hasRole(role)) {
                return true;
            }
        }
        return false;
    }
}
