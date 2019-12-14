package com.chris.shiro.service;

import com.chris.shiro.dao.RoleRepository;
import com.chris.shiro.dao.UserRepository;
import com.chris.shiro.model.Permission;
import com.chris.shiro.model.Role;
import com.chris.shiro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LoginServiceImpl {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    /**
     * 添加用户
     * @param map
     * @return
     */
    public User addUser(Map<String, Object> map) {
        User user = new User();
        user.setName(map.get("username").toString());
        user.setPassword(Integer.valueOf(map.get("password").toString()));
        userRepository.save(user);
        return user;
    }

    /**
     * 添加角色
     * @param map
     * @return
     */
    public Role addRole(Map<String, Object> map) {
        User user = userRepository.findOne(Long.valueOf(map.get("userId").toString()));
        Role role = new Role();
        role.setRoleName(map.get("roleName").toString());
        role.setUser(user);
        Permission permission1 = new Permission();
        permission1.setPermission("create");
        permission1.setRole(role);
        Permission permission2 = new Permission();
        permission2.setPermission("update");
        permission2.setRole(role);
        List<Permission> permissions = new ArrayList<Permission>();
        permissions.add(permission1);
        permissions.add(permission2);
        role.setPermissions(permissions);
        roleRepository.save(role);
        return role;
    }

    /**
     * 查询用户通过用户名
     * @param name
     * @return
     */
    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}