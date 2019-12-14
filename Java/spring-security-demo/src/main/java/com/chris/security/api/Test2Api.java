package com.chris.security.api;

import com.chris.security.utils.SecurityUtils;
import com.google.gson.Gson;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.support.SecurityWebApplicationContextUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 20:00
 * use for:
 */
@RestController
@RequestMapping("/api2")
public class Test2Api {
    @GetMapping(value = "/test",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> test() {
        Optional<String> userLogin= SecurityUtils.getCurrentUserLogin();
        String username = userLogin.get();
        //打印当前用户权限信息
        SecurityContext context=SecurityContextHolder.getContext();
        System.out.println(new Gson().toJson(context.getAuthentication()));
        System.out.println(context.getAuthentication().getCredentials());
        System.out.println(SecurityUtils.isAuthenticated());
        System.out.println(SecurityUtils.isCurrentUserInRole("ADMIN"));
        return ResponseEntity.ok("Test2 success: "+username);
    }

    @Secured({"ROLE_admin"})
    @GetMapping("/test1")
    public ResponseEntity<?> test1() {
        return ResponseEntity.ok("Test2-1 success.");
    }
}
