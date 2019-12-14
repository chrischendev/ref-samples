package com.chris.shiro.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 17:24
 * use for:
 */
@Service
public class UserService {
    private static Map<String, String> userMap = new HashMap<>(16);
    private static Map<String, String[]> roleMap = new HashMap<>(16);
    private static Map<String, String[]> permissionMap = new HashMap<>(16);

    @PostConstruct
    public void init() {
        //用户
        userMap.put("chris", "123456");
        userMap.put("kaly", "123456");
        userMap.put("chenfabao", "123456");
        userMap.put("sunfeifei", "123456");
        userMap.put("yaoshihan", "123456");

        //用户角色
        roleMap.put("chris", new String[]{"admin", "user"});
        roleMap.put("kaly", new String[]{"user"});
        roleMap.put("chenfabao", new String[]{"admin"});
        roleMap.put("sunfeifei", new String[]{"admin", "user"});
        roleMap.put("yaoshihan", new String[]{"user"});

        //角色权限
        permissionMap.put("admin", new String[]{"add", "delete", "update", "select"});
        permissionMap.put("user", new String[]{"select"});
    }

    public String getPasswordByUsername(String username) {
        return userMap.get(username);
    }

    public Set<String> getRolesByUsername(String username) {
        Set<String> roleSet = new HashSet<>();
        String[] roles = roleMap.get(username);
        for (String role : roles) {
            roleSet.add(role);
        }
        return roleSet;
    }

    public Set<String> getPermissionByUsername(String username) {
        Set<String> permissionSet = new HashSet<>();
        String[] roles = roleMap.get(username);
        for (String role : roles) {
            String[] permissions = permissionMap.get(role);
            for (String perm : permissions) {
                permissionSet.add(perm);
            }
        }
        return permissionSet;
    }

}
