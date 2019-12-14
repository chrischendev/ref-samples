package com.chris.sec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * create by: Chris Chan
 * create on: 2019/10/11 12:31
 * use for:
 */
@Service
public class UserService implements UserDetailsService {
    private static Map<String, String> userMap = new HashMap<>(16);
    private static Map<String, String> userAuthMap = new HashMap<>(16);
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        String password = findUser(username);
        if (StringUtils.isEmpty(password)) {
            return null;
        }
        return new User(username, password, getAuthorityList(username));
    }

    /**
     * 返回密码
     * 这个方法可以假设是从数据库dao层获取到用户信息
     *
     * @param username
     * @return
     */
    private String findUser(String username) {
        if (null == userMap) {
            userMap = new HashMap<>(16);
        }
        //内置几个用户
        if (userMap.size() == 0) {
            userMap.put("zhangsanfeng", passwordEncoder.encode("123123"));
            userMap.put("lisifu", passwordEncoder.encode("123123"));
            userMap.put("songzihao", passwordEncoder.encode("123123"));
        }
        return userMap.get(username);
    }

    /**
     * 获取用户权限
     * 这个方法也可以在数据库中查询
     *
     * @param username
     * @return
     */
    private List<GrantedAuthority> getAuthorityList(String username) {

        if (null == userAuthMap) {
            userAuthMap = new HashMap<>(16);
        }
        //内置几个用户权限
        if (userAuthMap.size() == 0) {
            userAuthMap.put("zhangsanfeng", "ROLE_ADMIN,ROLE_USER");
            userAuthMap.put("lisifu", "ROLE_ADMIN,ROLE_USER");
            userAuthMap.put("songzihao", "ROLE_SYS,ROLE_ADMIN,ROLE_USER");
        }
        return AuthorityUtils.createAuthorityList(userAuthMap.get(username).split(","));
    }
}
