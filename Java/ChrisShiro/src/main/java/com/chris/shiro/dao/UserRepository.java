package com.chris.shiro.dao;

import com.chris.shiro.model.User;

public interface UserRepository extends BaseRepository<User, Long> {
    User findByName(String name);
}