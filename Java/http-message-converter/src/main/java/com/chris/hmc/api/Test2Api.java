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
public class Test2Api {

    @GetMapping(value = "/getUser4")
    @ApiOperation(value = "获取用户4")
    public UserModel getUser4(HttpServletRequest request) {
        System.out.println(request.getHeader("Accept"));
        return new UserModel("陈凯利", 35, "男", "上海嘉定");
    }

    @GetMapping(value = "/getUser5")
    @ApiOperation(value = "获取用户5")
    public NetResult<UserModel> getUser5() {
        UserModel userModel = new UserModel("克丽丝", 35, "男", "上海嘉定");
        return NetResult.create(0, "success", userModel);
    }
}
