package com.chris.web.model.qo01;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "cc_test_grade")
public class Qo01GradeEntity implements Serializable {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "school_id")@JsonIgnore
    private String schoolId;

    @ManyToOne
    @JoinColumn(name = "school_id",referencedColumnName = "id",insertable = false, updatable = false)
    @JsonIgnoreProperties("gradeEntities")
    private Qo01SchoolEntity schoolEntity;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "gradeEntity")
//    @JsonIgnore
    @JsonIgnoreProperties("gradeEntity")
    private Set<Qo01ClassEntity> classEntities;
}
