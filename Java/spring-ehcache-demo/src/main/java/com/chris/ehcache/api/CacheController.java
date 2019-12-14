package com.chris.ehcache.api;

import com.chris.ehcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 16:04
 * use for:
 */
@RestController
@RequestMapping("/api")
public class CacheController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserById")
    public ResponseEntity<?> getUserById(int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }
}
