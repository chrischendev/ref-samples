package com.chris.shiro.api;

import com.chris.shiro.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 15:48
 * use for:
 */
@RestController
@RequestMapping("/user")
public class AccountApi {

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return ResponseEntity.ok(accountService.login(username, password, request, response));
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok("Logout success.");
    }

    @GetMapping("/index")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok("Show you Index.");
    }

    @GetMapping("/error")
    public ResponseEntity<?> error() {
        return ResponseEntity.ok("error.");
    }

}
