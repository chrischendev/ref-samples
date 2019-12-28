package com.chris.data.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 4:10
 * Use for:
 */
@RestController
@RequestMapping("/api")
public class TestApi {
    @GetMapping("/getAll")
    public void getAll() {

    }

    @PostMapping("/addUser")
    public void add() {

    }
}
