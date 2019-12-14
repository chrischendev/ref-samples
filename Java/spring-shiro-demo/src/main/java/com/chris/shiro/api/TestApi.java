package com.chris.shiro.api;

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
@RequestMapping("/api")
public class TestApi {

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Test success.");
    }

    @GetMapping("/test1")
    public ResponseEntity<?> test1(String info) {
        return ResponseEntity.ok("Test Info " + info + " success.");
    }

    @GetMapping("/test2")
    public ResponseEntity<?> test2(String info) {
        return ResponseEntity.ok("Test Info " + info + " success.");
    }

    @GetMapping("/testMyRoles")
    public ResponseEntity<?> testMyRoles() {
        return ResponseEntity.ok("Test testMyRoles success.");
    }

    @GetMapping("/testMyRoles2")
    public ResponseEntity<?> testMyRoles2() {
        return ResponseEntity.ok("Test testMyRoles2 success.");
    }
}
