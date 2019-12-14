package com.chris.sec.api;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/10/11 11:20
 * use for:
 */
@RestController
@RequestMapping("/api/test")
public class TestApi {
    @GetMapping("/test")
    public String test() {
        return "Test success.";
    }

    @Secured("ROLE_SYS")
    @GetMapping("/test2")
    public String test2() {
        return "Test2 success.";
    }
}
