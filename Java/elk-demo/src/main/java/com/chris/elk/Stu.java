package com.chris.elk;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * create by: Chris Chan
 * create on: 2019/7/30 11:50
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "stu_test", type = "stu_test")
public class Stu {
    @Id
    private String id;
    private String name;
    private int age;
    private String address;
    private String schClass;

    public Stu(String name, int age, String address, String schClass) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.schClass = schClass;
    }
}
