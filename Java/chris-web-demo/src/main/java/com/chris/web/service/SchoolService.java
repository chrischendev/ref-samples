package com.chris.web.service;

import com.chris.web.dao.Qo02SchoolDao;
import com.chris.web.dao.Qo02StuDao;
import com.chris.web.dao.Qo02StuExtDao;
import com.chris.web.model.qo02.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2019/5/16 13:57
 * Use for:
 */
@Service
public class SchoolService {
    @Autowired
    Qo02SchoolDao schoolDao;
    @Autowired
    Qo02StuDao stuDao;
    @Autowired
    Qo02StuExtDao stuExtDao;
    @Autowired
    EntityManager em;

    //使用JPA多条件构建多表联查
    public Page<Qo02SchoolEntity> searchSchoolPage(int page, int pagesize) {
        Specification<Qo02SchoolEntity> spec = new Specification<Qo02SchoolEntity>() {
            @Override
            public Predicate toPredicate(Root<Qo02SchoolEntity> school, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();

                Join<Qo02SchoolEntity, Qo02GradeEntity> schoolGrade = school.join("gradeEntities", JoinType.INNER);
                Join<Qo02GradeEntity, Qo02ClassEntity> schoolClass = schoolGrade.join("classEntities", JoinType.INNER);
                Join<Qo02ClassEntity, Qo02StuEntity> schoolStu = schoolClass.join("stuEntities", JoinType.INNER);

                predicateList.add(criteriaBuilder.equal(school.get("flag"), 1));
                predicateList.add(criteriaBuilder.equal(schoolStu.get("flag"), 1));

                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return schoolDao.findAll(spec, PageRequest.of(page, pagesize));
    }

    //使用JPA构建多条件多表联查获取扩展数据结果 todo 未成功
    public Page<Qo02StuExtEntity> searchStuExtPage(int page, int pagesize, int flag) {
        Specification<Qo02StuExtEntity> spec = new Specification<Qo02StuExtEntity>() {
            @Override
            public Predicate toPredicate(Root<Qo02StuExtEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                CriteriaQuery<Qo02StuEntity> cq = cb.createQuery(Qo02StuEntity.class);
                Root<Qo02SchoolEntity> school = cq.from(Qo02SchoolEntity.class);

                List<Predicate> predicateList = new ArrayList<>();

                Join<Qo02SchoolEntity, Qo02GradeEntity> schoolGrade = school.join("gradeEntities", JoinType.INNER);
                Join<Qo02GradeEntity, Qo02ClassEntity> schoolClass = schoolGrade.join("classEntities", JoinType.INNER);
                Join<Qo02ClassEntity, Qo02StuEntity> schoolStu = schoolClass.join("stuEntities", JoinType.INNER);

                cq.multiselect(
                        schoolStu.get("id").alias("id"),
                        schoolStu.get("name").alias("name"),
                        schoolStu.get("age").alias("age"),
                        schoolStu.get("address").alias("address"),
                        schoolStu.get("classId").alias("class_id"),
                        schoolStu.get("flag").alias("flag"),
                        school.get("name").alias("school_name"),
                        schoolGrade.get("name").alias("grade_name"),
                        schoolClass.get("name").alias("class_name")
                );

                //cq.where(cb.equal(schoolStu.get("flag"), flag));
                //cq.groupBy(schoolStu.get("id"));

                predicateList.add(cb.equal(schoolStu.get("flag"), flag));

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return stuExtDao.findAll(spec, PageRequest.of(page, pagesize));
    }

    //使用EntityManager构建多条件多表联查
    public List<Qo02StuEntity> searchStuPage(int page, int pagesize, int flag) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Qo02StuEntity> cq = cb.createQuery(Qo02StuEntity.class);
        Root<Qo02SchoolEntity> school = cq.from(Qo02SchoolEntity.class);

        Join<Qo02SchoolEntity, Qo02GradeEntity> schoolGrade = school.join("gradeEntities", JoinType.INNER);
        Join<Qo02GradeEntity, Qo02ClassEntity> schoolClass = schoolGrade.join("classEntities", JoinType.INNER);
        Join<Qo02ClassEntity, Qo02StuEntity> schoolStu = schoolClass.join("stuEntities", JoinType.INNER);

        cq.select(schoolStu);

        cq.where(cb.equal(schoolStu.get("flag"), flag));

        cq.groupBy(schoolStu.get("id"));

        TypedQuery<Qo02StuEntity> typedQuery = em.createQuery(cq);
        //分页求总数的策略
        long count = typedQuery.getResultList().size();
        System.out.println("count: " + count);

        typedQuery.setFirstResult(page * pagesize);
        typedQuery.setMaxResults(pagesize);
        List<Qo02StuEntity> resultList = typedQuery.getResultList();

        return resultList;

    }

    //使用EntityManager构建多条件多表联查获取扩展数据结果 成功
    public List<Qo02StuExtEntity> searchStuPage1(int page, int pagesize, int flag) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Qo02StuExtEntity> cq = cb.createQuery(Qo02StuExtEntity.class);
        Root<Qo02SchoolEntity> school = cq.from(Qo02SchoolEntity.class);

        Join<Qo02SchoolEntity, Qo02GradeEntity> schoolGrade = school.join("gradeEntities", JoinType.INNER);
        Join<Qo02GradeEntity, Qo02ClassEntity> schoolClass = schoolGrade.join("classEntities", JoinType.INNER);
        Join<Qo02ClassEntity, Qo02StuEntity> schoolStu = schoolClass.join("stuEntities", JoinType.INNER);

        cq.multiselect(
                schoolStu.get("id").alias("id"),
                schoolStu.get("name").alias("name"),
                schoolStu.get("age").alias("age"),
                schoolStu.get("address").alias("address"),
                schoolStu.get("classId").alias("class_id"),
                schoolStu.get("flag").alias("flag"),
                school.get("name").alias("school_name"),
                schoolGrade.get("name").alias("grade_name"),
                schoolClass.get("name").alias("class_name")
        );


        //构建条件
        Predicate predicate = cb.conjunction();
        List<Expression<Boolean>> expressions = predicate.getExpressions();

        expressions.add(cb.equal(school.get("flag"), 1));
        expressions.add(cb.equal(schoolGrade.get("flag"), 1));
        expressions.add(cb.equal(schoolClass.get("flag"), 1));
        expressions.add(schoolStu.get("flag").in(flag));
//        expressions.add(cb.equal(schoolStu.get("flag"), flag));
//        expressions.add(cb.or(cb.equal(schoolStu.get("flag"), 1), cb.equal(schoolStu.get("flag"), 0)));

        cq.where(predicate);
        cq.groupBy(schoolStu.get("id"));

        TypedQuery<Qo02StuExtEntity> typedQuery = em.createQuery(cq);
        typedQuery.setFirstResult(page * pagesize);
        typedQuery.setMaxResults(pagesize);
        List<Qo02StuExtEntity> resultList = typedQuery.getResultList();

        //求总数 成功
        CriteriaQuery<Long> cq1 = cb.createQuery(Long.class);
        Root<Qo02SchoolEntity> school1 = cq1.from(Qo02SchoolEntity.class);

        Join<Qo02SchoolEntity, Qo02GradeEntity> schoolGrade1 = school1.join("gradeEntities", JoinType.INNER);
        Join<Qo02GradeEntity, Qo02ClassEntity> schoolClass1 = schoolGrade1.join("classEntities", JoinType.INNER);
        Join<Qo02ClassEntity, Qo02StuEntity> schoolStu1 = schoolClass1.join("stuEntities", JoinType.INNER);

        cq1.multiselect(cb.countDistinct(schoolStu1.get("id")).alias("count"));
        cq1.where(predicate);

        TypedQuery<Long> query1 = em.createQuery(cq1);
        long count = executeCountQuery(query1);

        System.out.println("count: " + count);

        return resultList;

    }

    public Page<Qo02StuEntity> searchStuPage3(int page, int pagesize, int flag) {
        return stuDao.findAll(PageRequest.of(page, pagesize));
    }

    public Page<Qo02StuEntity> searchStuPage2(int page, int pagesize) {
        Specification<Qo02StuEntity> spec = new Specification<Qo02StuEntity>() {
            @Override
            public Predicate toPredicate(Root<Qo02StuEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                criteriaQuery.select();
                return null;
            }
        };
        return stuDao.findAll(spec, PageRequest.of(page, pagesize));
    }

    //从源码中移植的方法
    private static long executeCountQuery(TypedQuery<Long> query) {
        Assert.notNull(query, "TypedQuery must not be null!");
        List<Long> totals = query.getResultList();
        long total = 0L;

        Long element;
        for (Iterator var4 = totals.iterator(); var4.hasNext(); total += element == null ? 0L : element) {
            element = (Long) var4.next();
        }

        return total;
    }

}
