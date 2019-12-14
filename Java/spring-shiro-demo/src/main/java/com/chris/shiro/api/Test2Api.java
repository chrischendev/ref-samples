package com.chris.shiro.api;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 15:48
 * use for:
 */
@RestController
@RequestMapping("/api2")
public class Test2Api {

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Test success.");
    }

    @GetMapping("/test1")
    public ResponseEntity<?> test1(String info) {
        return ResponseEntity.ok("Test Info " + info + " success.");
    }

    @RequiresRoles("admin")
    @GetMapping("/testRole")
    public ResponseEntity<?> testRole() {
        return ResponseEntity.ok("Test role admin success.");
    }

    @RequiresPermissions("delete")
    @GetMapping("/testPerm")
    public ResponseEntity<?> testPerm() {
        return ResponseEntity.ok("Test permission delete success.");
    }
}
