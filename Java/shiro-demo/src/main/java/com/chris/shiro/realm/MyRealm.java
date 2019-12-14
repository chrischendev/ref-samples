package com.chris.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 14:26
 * use for:
 */
public class MyRealm extends AuthorizingRealm {
    private static Map<String, String> userMap = new HashMap<>(16);
    private static final String REALM_NAME = "myRealm";

    {
        userMap.put("chenfabao", "123456");
        userMap.put("sunfeifei", "123456");
        userMap.put("yaoshihan", "123456");

        super.setName(REALM_NAME);
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        String password = userMap.get(username);
        if (null == password) {
            return null;
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(getRolesByUsername(username));
        authorizationInfo.addStringPermissions(getPermissionsByUsername(username));
        return authorizationInfo;
    }

    /**
     * 认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = userMap.get(username);
        if (null == password) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, REALM_NAME);
        return authenticationInfo;
    }

    /**
     * 获取角色
     *
     * @param username
     * @return
     */
    private Set<String> getRolesByUsername(String username) {
        Set<String> roleSet = new HashSet<>();
        roleSet.add("admin");
        roleSet.add("user");
        return roleSet;
    }

    /**
     * 获取权限
     *
     * @param username
     * @return
     */
    private Set<String> getPermissionsByUsername(String username) {
        Set<String> permissionSet = new HashSet<>();
        permissionSet.add("add");
        permissionSet.add("delete");
        permissionSet.add("update");
        permissionSet.add("select");
        return permissionSet;
    }
}
