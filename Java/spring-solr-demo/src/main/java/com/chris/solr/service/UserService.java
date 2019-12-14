package com.chris.solr.service;

import com.chris.solr.model.User;

import java.util.List;

/**
 * @author chrischan
 * create on 2019/6/25 15:34
 * use for:
 */

public interface UserService {
    boolean addUserList(List<User> userList);

    boolean addUsers();
}
