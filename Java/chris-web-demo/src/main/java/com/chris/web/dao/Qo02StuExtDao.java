package com.chris.web.dao;

import com.chris.web.model.qo02.Qo02StuExtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:41
 * Use for:
 */
public interface Qo02StuExtDao extends JpaRepository<Qo02StuExtEntity, Integer>, JpaSpecificationExecutor<Qo02StuExtEntity> {
}
