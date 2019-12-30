package com.chris.hmc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Create by Chris Chan
 * Create on 2019/12/30 1:58
 * Use for: 实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {
    private String name;
    private int age;
    private String gender;
    private String address;
}
