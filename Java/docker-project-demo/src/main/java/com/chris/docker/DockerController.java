package com.chris.docker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * create by: Chris Chan
 * create on: 2019/6/15 19:03
 * use for:
 */
@RestController
@RequestMapping("/api")
public class DockerController {
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        System.out.println("Accept request. on " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").format(LocalDateTime.now()));
        return ResponseEntity.ok("test success.");

    }
}
