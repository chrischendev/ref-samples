package com.chris.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chrischan
 * create on 2019/6/24 9:50
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String[] permissions;

    public static User create(int id, String name, String password, String... permissions) {
        return new User(id, name, password, permissions);
    }
}
