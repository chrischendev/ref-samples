package com.chris.security.config;

import com.chris.security.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/9/26 8:08
 * use for: 全局变量
 */
public class AppManager {
    //内存用户
    public static List<User> userList=new ArrayList<>(16);

    public static void init(ApplicationContext applicationContext){
//        PasswordEncoder passwordEncoder = (PasswordEncoder) applicationContext.getBean(BCryptPasswordEncoder.class.getName());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userList.add(new User("user",passwordEncoder.encode("123456"),41,"上海杨浦"));
        userList.add(new User("admin",passwordEncoder.encode("123456"),41,"上海杨浦"));
        userList.add(new User("chris",passwordEncoder.encode("123456"),41,"上海杨浦"));
        userList.add(new User("chenfabao",passwordEncoder.encode("123456"),41,"上海杨浦"));
    }
}
