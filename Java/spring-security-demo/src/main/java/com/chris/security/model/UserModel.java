package com.chris.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/6/22 19:50
 * use for:
 */
@Data@NoArgsConstructor@AllArgsConstructor
public class UserModel {
    private String username;
    private String password;
}
