package com.chris.mm.web.api;

import com.chris.mm.web.service.ManService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chrischan
 * create on 2019\7\17 0017 10:00
 * use for:
 */
@RestController
@RequestMapping("/man")
public class ManApi {
    private static final String SWAGGER_TAGS = "1. 服务管理";
    @Autowired
    ManService manService;

    @GetMapping("/ver")
    @ApiOperation(value = "发布版本标记",tags = SWAGGER_TAGS)
    public ResponseEntity<?> ver() {
        return ResponseEntity.ok("2019-07-17");
    }
}
