package com.chris.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Create by Chris Chan
 * Create on 2020/1/5 11:50
 * Use for: Jpa模式
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("user_doc")
public class UserDocument {
    @MongoId
    private String id;
    private String name;
    private int age;

    public UserDocument(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static UserDocument create(String name, int age) {
        return new UserDocument(name, age);
    }
}
