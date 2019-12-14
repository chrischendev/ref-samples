package com.chris.couchbase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create by: Chris Chan
 * create on: 2019/6/16 22:23
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    private String name;
    private int age;
    private String address;
}
