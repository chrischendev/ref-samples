package com.chris.solr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;

/**
 * @author chrischan
 * create on 2019/6/25 15:32
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {
    @Field
    private String id;
    @Field
    private String username;
    @Field
    private String password;
}
