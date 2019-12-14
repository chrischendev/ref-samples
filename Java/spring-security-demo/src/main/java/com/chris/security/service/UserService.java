package com.chris.security.service;

import com.chris.security.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 19:49
 * use for:
 */
@Service
public class UserService implements UserDetailsService {
    private static Map<String, String> userMap = new HashMap<>();

    @PostConstruct
    public void init() {
        userMap.put("chenfabao", "123456");
        userMap.put("sunfeifei", "123456");
        userMap.put("yaoshihan", "123456");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        UserModel userModel = getUserByUsername(username);
        if (null == userModel) {
            return null;
        }
        User user = new User(userModel.getUsername(), userModel.getPassword(), getGrantedAuthoritySetByUsername(username));
        return user;
    }

    public UserModel getUserByUsername(String username) {
        return new UserModel(username, userMap.get(username));
    }

    public Set<String> getRolesByUsername(String username) {
        Set<String> roleSet = new HashSet<>();
        //roleSet.add("admin");
        roleSet.add("user");
        return roleSet;
    }

    public Set<String> getAuthsByUsername(String username) {
        Set<String> permissionSet = new HashSet<>();
        permissionSet.add("add");
        permissionSet.add("update");
        return permissionSet;
    }

    public Set<? extends GrantedAuthority> getGrantedAuthoritySetByUsername(String username) {
        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        Set<String> roles = getRolesByUsername(username);
        for (String role : roles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role));
        }
        return grantedAuthoritySet;
    }
}
