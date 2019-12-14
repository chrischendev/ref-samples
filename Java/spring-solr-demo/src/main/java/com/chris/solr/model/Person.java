package com.chris.solr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @author chrischan
 * create on 2019/6/25 9:54
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    //id有默认类型为string
    @Field("id")
    private String id;
    @Field("name")
    private String[] name;
    @Field("description")
    private String[] description;

    public Person(String id, String name, String description) {
        this.id = id;
        this.name = new String[]{name};
        this.description = new String[]{description};
    }
}
