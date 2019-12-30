package com.chris.hmc.api;

import com.chris.hmc.model.NetResult;
import com.chris.hmc.model.UserModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by Chris Chan
 * Create on 2019/12/30 1:56
 * Use for:
 */
@RestController
@RequestMapping("/api")
@Api(value = "测试接口")
public class TestApi {

    @GetMapping(value = "/getUser", produces = "application/x-chris")
    @ApiOperation(value = "获取用户")
    public UserModel getUser(HttpServletRequest request) {
        System.out.println(request.getHeader("Accept"));
        return new UserModel("chrischen", 32, "男", "上海嘉定");
    }

    @GetMapping(value = "/getUser2", produces = "application/x-chris")
    @ApiOperation(value = "获取用户2")
    public UserModel getUser2(String name) {
        return new UserModel(name, 32, "男", "上海嘉定");
    }

    @GetMapping(value = "/getUser3", produces = "application/x-chris")
    @ApiOperation(value = "获取用户3")
    public NetResult<UserModel> getUser3() {
        UserModel userModel = new UserModel("kaly", 32, "男", "上海嘉定");
        return NetResult.create(0, "success", userModel);
    }
}
