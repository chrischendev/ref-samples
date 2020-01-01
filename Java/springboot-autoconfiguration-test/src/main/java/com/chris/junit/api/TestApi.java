package com.chris.junit.api;

import com.chris.sad.ChrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/12/30 1:56
 * Use for:
 */
@RestController
@RequestMapping("/api")
public class TestApi {
    //包被排除，自定义的自动配置失效了
    @Autowired
    ChrisService chrisService;

    @GetMapping("/test")
    public String test() {
        chrisService.say();
        return "success.";
    }

}
