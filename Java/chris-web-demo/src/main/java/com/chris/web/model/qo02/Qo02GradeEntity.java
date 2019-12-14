package com.chris.web.model.qo02;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Create by Chris Chan
 * Create on 2019/4/24 9:47
 * Use for:
 */
@Data
@Entity
@Table(name = "cc_test_grade")
//@Where(clause = "name='二年级'")
public class Qo02GradeEntity implements Serializable {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "school_id")
    @JsonIgnore
    private String schoolId;
    @Column(name = "flag")
    private int flag;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "grade_id", referencedColumnName = "id", insertable = false, updatable = false)
    //@Where(clause = "name='一班'")
    //@JsonIgnore
    private Set<Qo02ClassEntity> classEntities = new HashSet<>();
}
