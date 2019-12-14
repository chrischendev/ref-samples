package com.chris.web.dao;

import com.chris.web.dao.sql.Qo03Sql;
import com.chris.web.model.qo03.Qo03SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/4/25 9:41
 * Use for:
 */
public interface Qo03SchoolDao extends JpaRepository<Qo03SchoolEntity, Integer>, Qo03Sql {

    @Query(value = SQL_FIND_SCHOOLS, nativeQuery = true)
    List<Qo03SchoolEntity> findSchools();

}
