package com.chris.mongodb.api;

import com.chris.mongodb.dao.UserRepository;
import com.chris.mongodb.model.UserDocument;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2020/1/5 12:31
 * Use for: Jpa模式
 */
@RestController
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    UserRepository userRepository;

    private static Gson gson = new Gson();

    @GetMapping("/add")
    public String addDocument() {
        userRepository.save(UserDocument.create("兰心若", 1000));
        userRepository.save(UserDocument.create("黄玲", 18));
        userRepository.save(UserDocument.create("白珑", 17));
        return "add success.";
    }

    @GetMapping("/findAll")
    public List<UserDocument> getDocuments() {
        return userRepository.findAll();
    }

}
