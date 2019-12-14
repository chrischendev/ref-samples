package com.chris.security.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/9/26 8:00
 * use for:
 */
@RestController
@RequestMapping("/api/test")
public class TestApi {
    @PostMapping("/test")
    public String test() {
        return "test success.";
    }
}
