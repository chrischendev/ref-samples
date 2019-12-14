package com.chris.shiro.config;

import com.chris.shiro.config.filter.MyRolesFilter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 15:55
 * use for:
 */
@Configuration
public class ShiroConfig {

    @Bean
    public SecurityManager securityManager(AuthorizingRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);

        //securityManager.setSessionManager(new DefaultWebSessionManager());//会话管理器 未研究
        //securityManager.setCacheManager(new MemoryConstrainedCacheManager());//缓存管理器 未研究

        SecurityUtils.setSecurityManager(securityManager);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        //shiroFilterFactoryBean.setSuccessUrl("/user/index");
        //shiroFilterFactoryBean.setUnauthorizedUrl("/user/error");

        Map<String, Filter> filterMap = new LinkedHashMap<>(16);//如果有自定义的filter，需要用到这个
        filterMap.put("myRoles", new MyRolesFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        Map<String, String> filterChainMap = new LinkedHashMap<>(16);//有序MAP,过滤器链
        filterChainMap.put("/user/login", "anon");// /user/login登录接口不做权限验证
        filterChainMap.put("/api/testMyRoles", "myRoles[admin,user]");// 单独的接口 检查自定义的filter 只需要满足其中一种 or的关系
        filterChainMap.put("/api/testMyRoles2", "roles[admin,user]");//必须同时满足两种角色 缺一不可 and关系
        filterChainMap.put("/api/**", "anon");// /api2/下的所有接口不做权限验证
        filterChainMap.put("/user/logout", "logout");// 退出登录的匹配路径为/user/logout
        filterChainMap.put("/**", "authc");//其他所有接口都需要做权限验证

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 加入注解的使用，不加入这个注解不生效
     * 主要应用于权限验证
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
