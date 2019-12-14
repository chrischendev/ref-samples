package com.chris.mm.module02;

import com.chris.mm.base.libs.StudentModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chrischan
 * create on 2019\7\17 0017 15:24
 * use for:
 */
@RestController
@RequestMapping("/m2")
public class Module02Api {
    private static final String SWAGGER_TAGS = "4. 模块二";
    @Autowired
    Module02Service module02Service;

    @GetMapping("/getStu")
    @ApiOperation(value = "获取学生信息", tags = SWAGGER_TAGS)
    public StudentModel getStu() {
        return module02Service.getStu();
    }
}
