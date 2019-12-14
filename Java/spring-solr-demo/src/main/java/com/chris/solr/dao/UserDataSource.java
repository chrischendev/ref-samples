package com.chris.solr.dao;

import com.chris.solr.model.User;

import java.util.List;

/**
 * @author chrischan
 * create on 2019/6/25 15:36
 * use for:
 */
public interface UserDataSource {
    List<User> getUserList();
}
