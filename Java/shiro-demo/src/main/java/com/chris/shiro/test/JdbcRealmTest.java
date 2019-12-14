package com.chris.shiro.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.chris.shiro.manager.AppManager;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;

/**
 * @author chrischan
 * create on 2019/6/21 15:30
 * use for:
 */
public class JdbcRealmTest {
    private static JdbcRealm realm;

    public static void main(String[] args) {
        initRealm();
        testAuthentication();
        testAuthorization();
    }

    /**
     * 授权 角色和权限
     */
    private static void testAuthorization() {
        Subject subject = AppManager.getSubject(realm);
        UsernamePasswordToken token = new UsernamePasswordToken("sunfeifei", "123456");
        subject.login(token);

        boolean admin = subject.hasRole("admin");
        System.out.println("isAdmin: " + admin);

        subject.checkRoles("admin");
        subject.checkPermission("add");//检查权限
    }

    /**
     * 认证 判断认证用户是不是已经存在的用户
     */
    private static void testAuthentication() {
        Subject subject = AppManager.getSubject(realm);
        UsernamePasswordToken token = new UsernamePasswordToken("chenfabao", "123456");
        subject.login(token);

        System.out.println("isAuthentication: " + subject.isAuthenticated());
        //subject.logout();//退出登录
        //System.out.println("isAuthentication: " + subject.isAuthenticated());
    }

    /**
     * 初始化realm，并创建用户信息
     */
    private static void initRealm() {
        realm = new JdbcRealm();
        DruidDataSource dataSource = new DruidDataSource();
        String jdbcUrl = "jdbc:mysql://47.97.183.139:3306/db_chris_shiro?useSSL=false";
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername("chris");
        dataSource.setPassword("Gk!123456");
        realm.setDataSource(dataSource);
        realm.setPermissionsLookupEnabled(true);//查询权限

        //设置自定义的sql语句
        realm.setAuthenticationQuery("select password from tb_users where username = ?");
        realm.setUserRolesQuery("select role_name from tb_user_roles where username = ?");
        realm.setPermissionsQuery("select permission from tb_roles_permissions where role_name = ?");
    }
}
