package com.chris.mm.web.api;

import com.chris.mm.module02.Module02Service;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chrischan
 * create on 2019\7\17 0017 10:14
 * use for:
 */
@RestController
@RequestMapping("/test")
public class TestApi {
    private static final String SWAGGER_TAGS = "2. 测试";

    @Autowired
    Module02Service module02Service;

    @GetMapping("/getm2")
    @ApiOperation(value = "获取模块二", tags = SWAGGER_TAGS)
    public ResponseEntity<?> getm2() {
        return ResponseEntity.ok(module02Service.getInfo());
    }
}
