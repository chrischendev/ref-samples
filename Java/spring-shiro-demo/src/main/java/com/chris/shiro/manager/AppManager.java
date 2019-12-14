package com.chris.shiro.manager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.Subject;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 15:41
 * use for:
 */
public class AppManager {
    public static Subject getSubject(AuthorizingRealm realm) {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }
}
