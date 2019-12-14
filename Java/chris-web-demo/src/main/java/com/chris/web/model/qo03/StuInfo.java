package com.chris.web.model.qo03;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Create by Chris Chan
 * Create on 2019/5/16 14:10
 * Use for:
 */
@Data
@Embeddable
public class StuInfo implements Serializable {
    @Column(name = "stu_name")
    private String name;
    @Column(name = "stu_age")
    private int age;
    @Column(name = "class_name")
    private String className;
    @Column(name = "grade_name")
    private String gradeName;
    @Column(name = "school_name")
    private String schoolName;

}
