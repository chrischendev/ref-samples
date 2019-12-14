package com.chris.shiro.manager;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.subject.Subject;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 8:59
 * use for:
 */
public class AppManager {
    /**
     * 获取主体
     */
    public static Subject getSubject(AuthenticatingRealm realm) {
        //1. 创建SecurityManager
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(realm);
        //2. 创建认证主体
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        return subject;
    }
}
