package com.chris.web.model.orm;

import javax.persistence.*;
import java.util.Objects;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:34
 * Use for:
 */
@Entity
@Table(name = "cc_test_stu", schema = "tech_dev", catalog = "")
public class CcTestStuEntity {
    private int id;
    private String name;
    private Integer age;
    private String address;
    private Integer classId;

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
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 128)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "class_id", nullable = true)
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CcTestStuEntity that = (CcTestStuEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(address, that.address) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, address, classId);
    }
}
