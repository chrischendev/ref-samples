package com.chris.postgresql.dao;

import com.chris.postgresql.model.orm.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostgreSqlDemo
 * com.echris.postgresql.dao
 * Created by Chris Chen
 * 2018/6/22
 * Explain:
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
