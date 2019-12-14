package com.chris.ehcache.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/6/23 9:39
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
