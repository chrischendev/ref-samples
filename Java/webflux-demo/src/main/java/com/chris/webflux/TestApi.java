package com.chris.webflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/12/4 11:32
 * use for:
 */
@RestController
@RequestMapping("/api")
public class TestApi {
    @GetMapping("/test")
    public String test() {
        return "webflux test called success.";
    }
}
