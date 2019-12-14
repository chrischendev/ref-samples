package com.chris.web.model.qo01;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:34
 * Use for:
 */
@Data
@Entity
@Table(name = "cc_test_class")
@Where(clause = "name = '二班' and grade_id = 1")
public class Qo01ClassEntity {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "grade_id")@JsonIgnore
    private Integer gradeId;

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnoreProperties("classEntities")
    private Qo01GradeEntity gradeEntity;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "classEntity")
//    @JsonIgnore
    @JsonIgnoreProperties("classEntity")
    private Set<Qo01StuEntity> stuEntities;

}
