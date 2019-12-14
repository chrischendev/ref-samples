package com.chris.solr.dao;

import com.chris.solr.model.User;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @author chrischan
 * create on 2019/6/25 15:56
 * use for:
 */
public interface UserRepository extends SolrCrudRepository<User, String> {

}
