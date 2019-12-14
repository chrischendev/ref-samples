package com.chris.solr.api;

import com.chris.solr.model.User;
import com.chris.solr.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author chrischan
 * create on 2019/6/25 15:45
 * use for:
 */
public interface SolrController {
    @GetMapping("/addUserList")
    ResponseEntity<?> addUserList();

    @PostMapping("/add")
    ResponseEntity<?> add(UserModel user);

    @PostMapping("/addList")
    ResponseEntity<?> addList(List<User> userList);

    @GetMapping("/deleteById")
    ResponseEntity<?> deleteById(String id);

    @PostMapping("/deleteByIds")
    ResponseEntity<?> deleteByIds(String[] ids);

    @GetMapping("/getUserById")
    ResponseEntity<?> getUserById(String id);

    @GetMapping("/getUserByUserName")
    ResponseEntity<?> getUserByUserName(String username);

    @GetMapping("/getAllUsers")
    ResponseEntity<?> getAllUsers(String username);
}
