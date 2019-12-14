package com.chris.ehcache.service;

import com.chris.ehcache.dao.UserDao;
import com.chris.ehcache.model.UserModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 16:04
 * use for:
 */
@Service
public class UserService {
    @Autowired
    Gson gson;
    @Autowired
    UserDao userDao;

    @Cacheable(value = "User", key = "#id")
    public UserModel getUserById(int id) {
        int nid = new Random().nextInt(5) + 1;
        UserModel userModel = userDao.getUserById(nid);
        System.out.println(gson.toJson(userModel));
        return userModel;
    }
}
