package com.chris.car.api;

import com.chris.car.config.IgnoreAdvice;
import com.chris.car.model.NetResult;
import com.chris.car.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
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
@Api(value = "测试接口")
public class TestApi {
    @IgnoreAdvice
    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户")
    public ResponseEntity<?> getUser() {
        UserModel userModel = new UserModel("chrischen", 32, "男", "上海嘉定");
        return ResponseEntity.ok(userModel);
    }

    @GetMapping("/getUser2")
    @ApiOperation(value = "获取用户2")
    public UserModel getUser2() {
        return new UserModel("chrischen", 32, "男", "上海嘉定");
    }

    @GetMapping("/getUser3")
    @ApiOperation(value = "获取用户3")
    public NetResult<UserModel> getUser3() {
        UserModel userModel = new UserModel("chrischen", 32, "男", "上海嘉定");
        return NetResult.create(0, "success", userModel);
    }
}
