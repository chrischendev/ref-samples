package com.chris.jwt.api;

import com.chris.jwt.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chrischan
 * create on 2019/6/24 9:22
 * use for:
 */
@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountService accountService;

    /**
     * 登录 登陆成功则返回一个token
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ResponseEntity<?> login(String username, String password) {
        return ResponseEntity.ok(accountService.login(username, password));
    }

    @PostMapping("/parseToken")
    public ResponseEntity<?> parseToken(String token, String field) {
        return ResponseEntity.ok(accountService.parseToken(token, field));
    }
}
