package com.chris.jpa.test;

import com.chris.jpa.custom.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2020/1/2 19:25
 * Use for:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/getUser")
    public PageData<UserEntity> getUser() {
        return userRepository.getPage(PageRequest.of(0, 10));
    }


}
