package com.chris.jpa.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Create by Chris Chan
 * Create on 2020/1/2 19:20
 * Use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_user")
public class UserEnt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(name = "name", nullable = false, length = 20)
    private String name;
    @Basic
    @Column(name = "age", nullable = true, length = 3)
    private Integer age;
    @Basic
    @Column(name = "address", nullable = true, length = 128)
    private String address;
}
