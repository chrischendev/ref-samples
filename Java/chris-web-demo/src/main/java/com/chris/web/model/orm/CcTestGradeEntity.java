package com.chris.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:34
 * Use for:
 */
@Entity
@Table(name = "cc_test_grade", schema = "tech_dev", catalog = "")
public class CcTestGradeEntity {
    private int id;
    private String name;
    private String description;
    private Integer schoolId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 128)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "school_id", nullable = true)
    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CcTestGradeEntity that = (CcTestGradeEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(schoolId, that.schoolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, schoolId);
    }
}
