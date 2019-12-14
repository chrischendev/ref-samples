package com.chris.docker.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/7/24 20:35
 * use for:
 */
@RestController
@RequestMapping("/api")
public class TestApi {
    @GetMapping("/test")
    public String test() {
        return "publish to docker success.";
    }

    @GetMapping(params = "1001")
    public String testParams(String i) {
        return "test params success: " + i;
    }
}
