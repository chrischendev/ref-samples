package com.chris.session.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 15:24
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private int id;
    private String name;
    private int age;
}
