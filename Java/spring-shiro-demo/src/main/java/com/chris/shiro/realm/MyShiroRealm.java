package com.chris.shiro.realm;

import com.chris.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 15:45
 * use for:
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {
    private static final String REALM_NAME = "myShiroRealm";
    @Autowired
    UserService userService;

    @PostConstruct
    public void initMe() {
        super.setName(REALM_NAME);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.getRolesByUsername(username));
        authorizationInfo.setStringPermissions(userService.getPermissionByUsername(username));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = userService.getPasswordByUsername(username);
        if (null == password) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, REALM_NAME);
        return authenticationInfo;
    }
}
