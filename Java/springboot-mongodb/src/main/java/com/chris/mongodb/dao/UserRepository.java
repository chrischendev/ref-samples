package com.chris.mongodb.dao;

import com.chris.mongodb.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Create by Chris Chan
 * Create on 2020/1/5 12:52
 * Use for:
 */
public interface UserRepository extends MongoRepository<UserDocument, String> {
}
