package com.chris.mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Chris Chan
 * Create on 2020/1/5 11:50
 * Use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String name;
    private int age;

    public static UserModel create(String name, int age) {
        return new UserModel(name, age);
    }
}
