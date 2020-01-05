package com.chris.mongodb.dao;

import com.chris.mongodb.model.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2020/1/5 12:52
 * Use for:
 */
public interface UserRepository extends MongoRepository<UserDocument, String> {
    /**
     * 根据姓名查询
     * @param name
     * @return
     */
    @Query("{'name':?0}")
    List<UserDocument> findByName(String name);
}
