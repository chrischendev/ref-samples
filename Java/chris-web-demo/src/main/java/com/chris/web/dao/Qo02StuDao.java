package com.chris.web.dao;

import com.chris.web.model.qo02.Qo02StuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:41
 * Use for:
 */
public interface Qo02StuDao extends JpaRepository<Qo02StuEntity, Integer>, JpaSpecificationExecutor<Qo02StuEntity> {
}
