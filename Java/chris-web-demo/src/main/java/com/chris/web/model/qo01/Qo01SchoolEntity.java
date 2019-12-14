package com.chris.web.model.qo01;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Create by Chris Chan
 * Create on 2019/4/24 9:47
 * Use for:
 */
@Data
@Entity
@Table(name = "cc_test_school")
public class Qo01SchoolEntity implements Serializable {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "schoolEntity")
    //@JsonIgnore
    @JsonIgnoreProperties("schoolEntity")
    private Set<Qo01GradeEntity> gradeEntities;
}
