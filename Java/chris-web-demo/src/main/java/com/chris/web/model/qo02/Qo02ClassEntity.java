package com.chris.web.model.qo02;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:34
 * Use for:
 */
@Data
@Entity
@Table(name = "cc_test_class")
//@Where(clause = "name = '二班' and grade_id = 1")
public class Qo02ClassEntity {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "grade_id")
    @JsonIgnore
    private Integer gradeId;
    @Column(name = "flag")
    private int flag;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "class_id", referencedColumnName = "id", insertable = false, updatable = false)
    //@Where(clause = "name='一班'")
    //@JsonIgnore
    private Set<Qo02StuEntity> stuEntities = new HashSet<>();
}
