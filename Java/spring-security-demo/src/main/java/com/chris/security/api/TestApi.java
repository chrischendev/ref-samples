package com.chris.security.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 20:00
 * use for:
 */
@RestController
@RequestMapping("/api")
public class TestApi {
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Test success.");
    }
}
