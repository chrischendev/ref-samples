package com.chris.solr.dao;

import com.chris.solr.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chrischan
 * create on 2019/6/25 15:36
 * use for:
 */
@Repository
public class UserDataSourceImpl implements UserDataSource {
    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            userList.add(new User(String.valueOf(i), "用户名", "123456"));
        }
        return userList;
    }
}
