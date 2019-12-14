package com.chris.solr.api;

import com.chris.solr.model.User;
import com.chris.solr.model.UserModel;
import com.chris.solr.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chrischan
 * create on 2019/6/25 15:45
 * use for:
 */
@RestController
@RequestMapping("/solr")
public class SolrControllerImpl implements SolrController {
    @Autowired
    UserServiceImpl userService;

    @Override
    public ResponseEntity<?> addUserList() {
        return ResponseEntity.ok(userService.addUsers());
    }

    @Override
    public ResponseEntity<?> add(@RequestBody UserModel user) {
        return null;
    }

    @Override
    public ResponseEntity<?> addList(@RequestBody List<User> userList) {
        return ResponseEntity.ok(userService.addUserList(userList));
    }

    @Override
    public ResponseEntity<?> deleteById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteByIds(@RequestBody String[] ids) {
        return null;
    }

    @Override
    public ResponseEntity<?> getUserById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> getUserByUserName(String username) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAllUsers(String username) {
        return null;
    }
}
