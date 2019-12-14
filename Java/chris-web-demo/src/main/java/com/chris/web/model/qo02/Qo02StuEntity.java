package com.chris.web.model.qo02;

import com.chris.web.model.qo01.Qo01ClassEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:34
 * Use for:
 */
@Data
@Entity
@Table(name = "cc_test_stu")
//@Where(clause = "age = 11")
public class Qo02StuEntity {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "address")
    private String address;
    @Column(name = "class_id")
    @JsonIgnore
    private Integer classId;
    @Column(name = "flag")
    private int flag;
}
