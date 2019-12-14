package com.chris.security.config;

import com.chris.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 19:52
 * use for:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)

public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //目前没有自定义的登录页面，就使用basic登录。不过一般有前端来设计，后端不用做这样的设计
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //在内存中创建几个用户
        auth
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("chris").password("123456").roles("user").and()
                .withUser("kaly").password("123456").roles("admin").and()
                .withUser("lion").password("123456").roles("admin", "user");

//        auth
//                .userDetailsService(userService)
//                .passwordEncoder(passwordEncoder);
    }
}
