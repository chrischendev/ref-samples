package com.chris.solr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @author chrischan
 * create on 2019/6/25 15:32
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SolrDocument(collection = "chris_core")
public class User implements Serializable {
    @Id
    @Indexed(name = "id")
    private String id;
    @Indexed(name = "username")
    private String username;
    @Indexed(name = "password")
    private String password;
}
