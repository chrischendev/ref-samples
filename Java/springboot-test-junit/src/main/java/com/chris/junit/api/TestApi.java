package com.chris.junit.api;

import com.chris.junit.model.NetResult;
import com.chris.junit.model.UserModel;
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

    @GetMapping("/getUser")
    public UserModel getUser() {
        return new UserModel("chrischen", 32, "男", "上海嘉定");
    }

    @GetMapping("/getUser2")
    public UserModel getUser2(String name) {
        return new UserModel(name, 32, "男", "上海嘉定");
    }

    @GetMapping("/getUser3")
    public NetResult<UserModel> getUser3() {
        UserModel userModel = new UserModel("kaly", 32, "男", "上海嘉定");
        return NetResult.create(0, "success", userModel);
    }
}
