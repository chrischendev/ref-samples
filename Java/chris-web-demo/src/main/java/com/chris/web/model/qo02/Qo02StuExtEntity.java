package com.chris.web.model.qo02;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:34
 * Use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "cc_test_stu")
public class Qo02StuExtEntity {
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
    @JsonIgnore
    private int flag;
    @Column(name = "school_name")
    @Transient
    private String schoolName;
    @Column(name = "grade_name")
    @Transient
    private String gradeName;
    @Column(name = "class_name")
    @Transient
    private String className;

}
