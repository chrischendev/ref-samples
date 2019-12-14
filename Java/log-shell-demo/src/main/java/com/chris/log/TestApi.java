package com.chris.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by: Chris Chan
 * create on: 2019/10/13 11:25
 * use for:
 */
@RestController
@RequestMapping("/api/test")
public class TestApi {
    private static Logger logger = LoggerFactory.getLogger("TestApi");

    @GetMapping("/test01")
    public String test01() {

        logger.trace("test01 called success.");
        logger.debug("test01 called success.");
        logger.info("test01 called success.");
        logger.warn("test01 called success.");
        logger.error("test01 called success.");
        return "test01 called success.";
    }
}
