package com.chris.web.model.qo03;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Create by Chris Chan
 * Create on 2019/4/24 9:47
 * Use for:
 */
@Data
@Entity
@Table(name = "cc_test_school")
public class Qo03SchoolEntity implements Serializable {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Enumerated
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "stu_name", insertable = false, updatable = false)),
            @AttributeOverride(name = "age", column = @Column(name = "stu_age", insertable = false, updatable = false)),
            @AttributeOverride(name = "className", column = @Column(name = "class_name", insertable = false, updatable = false)),
            @AttributeOverride(name = "gradeName", column = @Column(name = "grade_name", insertable = false, updatable = false)),
            @AttributeOverride(name = "schoolName", column = @Column(name = "school_name", insertable = false, updatable = false))
    })
    private StuInfo stuInfo;
}
