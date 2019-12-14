package com.chris.ehcache.dao;

import com.chris.ehcache.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 17:37
 * use for: User数据源
 */
@Component
public class UserDao {
    private static Map<Integer, UserModel> userMap = new HashMap<>();

    {
        userMap.put(1, new UserModel(1, "kaly", 40));
        userMap.put(2, new UserModel(2, "chris", 40));
        userMap.put(3, new UserModel(3, "will", 40));
        userMap.put(4, new UserModel(4, "fabio", 40));
        userMap.put(5, new UserModel(5, "mark", 40));
    }

    public UserModel getUserById(int id) {
        return userMap.get(id);
    }

}
