package com.chris.postgresql.api;

import com.chris.postgresql.model.orm.UserEntity;
import com.chris.postgresql.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * PostgreSqlDemo
 * com.echris.postgresql.api
 * Created by Chris Chen
 * 2018/6/22
 * Explain:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public Boolean add(@RequestBody UserEntity user) {
        return userRepository.saveAndFlush(user) != null;
    }

    @RequestMapping("/getList")
    public List<UserEntity> getList() {
        return userRepository.findAll();
    }
}
