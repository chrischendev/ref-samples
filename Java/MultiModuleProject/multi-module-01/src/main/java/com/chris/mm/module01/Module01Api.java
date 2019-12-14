package com.chris.mm.module01;

import com.chris.mm.base.libs.UserModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chrischan
 * create on 2019\7\17 0017 10:34
 * use for:
 */
@RestController
@RequestMapping("/m1")
public class Module01Api {
    private static final String SWAGGER_TAGS = "3. 模块一";

    @GetMapping("/getm1")
    @ApiOperation(value = "获取模块1信息", tags = SWAGGER_TAGS)
    public String getm1() {
        return "宝塔镇河妖";
    }

    @GetMapping("/getUser")
    @ApiOperation(value = "获取用户信息", tags = SWAGGER_TAGS)
    public UserModel getUser() {
        return ModuleUtils.getUser();
    }
}
