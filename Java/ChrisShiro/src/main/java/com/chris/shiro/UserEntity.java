package com.chris.shiro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * App: ChrisApplication
 * Pkg: com.chris.cv.model.orm
 * Author: Chris Chen
 * Time: 2018/08/16
 * Explain:
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "tb_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "username", nullable = true)
    private String username;

    @Basic
    @Column(name = "cell", nullable = true)
    private String cell;

    @Basic
    @Column(name = "password", nullable = true)
    private String password;

    @Basic
    @Column(name = "supper_password", nullable = true)
    private String supperPassword;

    @Basic
    @Column(name = "last_login_time", nullable = true)
    private Timestamp lastLoginTime;

    @Basic
    @Column(name = "token", nullable = true)
    private String token;

    @Basic
    @Column(name = "description", nullable = true)
    private String description;

}