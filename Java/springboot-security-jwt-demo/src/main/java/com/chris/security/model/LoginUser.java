package com.chris.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/9/26 8:09
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    private String username;
    private String password;

}
