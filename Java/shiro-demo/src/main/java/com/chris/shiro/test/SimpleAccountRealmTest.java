package com.chris.shiro.test;

import com.chris.shiro.manager.AppManager;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

/**
 * @author chrischan
 * create on 2019/6/21 15:30
 * use for:
 */
public class SimpleAccountRealmTest {
    private static SimpleAccountRealm realm;

    public static void main(String[] args) {
        initRealm();
        //testAuthentication();
        testAuthorization();
    }

    /**
     * 授权 角色和权限
     */
    private static void testAuthorization() {
        Subject subject = AppManager.getSubject(realm);
        UsernamePasswordToken token = new UsernamePasswordToken("kaly", "123456");
        subject.login(token);

        boolean admin = subject.hasRole("ADMIN");
        System.out.println("isAdmin: " + admin);
        subject.checkRoles("ADMIN", "USER");
        //subject.checkPermission("ADD");
    }

    /**
     * 认证 判断认证用户是不是已经存在的用户
     */
    private static void testAuthentication() {
        Subject subject = AppManager.getSubject(realm);
        UsernamePasswordToken token = new UsernamePasswordToken("kaly", "123456");
        subject.login(token);

        System.out.println("isAuthentication: " + subject.isAuthenticated());
        //subject.logout();//退出登录
        //System.out.println("isAuthentication: " + subject.isAuthenticated());
    }

    /**
     * 初始化realm，并创建用户信息
     */
    private static void initRealm() {
        realm = new SimpleAccountRealm();
        realm.addAccount("chris", "123456", "ADMIN", "USER");
        realm.addAccount("kaly", "123456", "ADMIN", "USER");
    }
}
