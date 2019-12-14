package com.chris.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Collections;
import java.util.List;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

/**
 * Create by Chris Chan
 * Create on 2019/5/29 17:33
 * Use for: todo 不可用
 */
public class JpaAssist {
    private static EntityManager em;

    public static void init(EntityManager entityManager) {
        JpaAssist.em = entityManager;
    }


    public static <T> Page<T> findAll(@Nullable Specification<T> spec, Pageable pageable, Class<T> domainClass) {
        //获得请求结果
        TypedQuery<T> query = getQuery(spec, pageable, domainClass);
        return isUnpaged(pageable) ? new PageImpl<T>(query.getResultList())
                : readPage(query, domainClass, pageable, spec);
    }

    private static <T> TypedQuery<T> getQuery(@Nullable Specification<T> spec, Pageable pageable, Class<T> domainClass) {

        Sort sort = pageable.isPaged() ? pageable.getSort() : Sort.unsorted();
        return getQuery(spec, domainClass, sort);
    }

    /**
     * 获取请求结果
     *
     * @param spec
     * @param domainClass
     * @param sort
     * @param <T>
     * @return
     */
    private static <T> TypedQuery<T> getQuery(@Nullable Specification<T> spec, Class<T> domainClass, Sort sort) {
        //创建条件构造器
        CriteriaBuilder builder = em.getCriteriaBuilder();
        //创建请求
        CriteriaQuery<T> query = builder.createQuery(domainClass);
        //获取主查询表 应用条件
        Root<T> root = applySpecificationToCriteria(spec, domainClass, query);
        //设定select部分
        query.select(root);

        if (sort.isSorted()) {
            query.orderBy(toOrders(sort, root, builder));
        }

        return applyRepositoryMethodMetadata(em.createQuery(query));
    }

    private static <S, T> Root<T> applySpecificationToCriteria(@Nullable Specification<T> spec, Class<T> domainClass, CriteriaQuery<S> query) {
        Assert.notNull(domainClass, "Domain class must not be null!");
        Assert.notNull(query, "CriteriaQuery must not be null!");

        Root<T> root = query.from(domainClass);

        if (spec == null) {
            return root;
        }

        CriteriaBuilder builder = em.getCriteriaBuilder();
        Predicate predicate = spec.toPredicate(root, query, builder);
        //应用where条件
        if (predicate != null) {
            query.where(predicate);
        }

        return root;
    }

    private static <T> TypedQuery<T> applyRepositoryMethodMetadata(TypedQuery<T> query) {

//        if (metadata == null) {
//            return query;
//        }
//
//        LockModeType type = metadata.getLockModeType();
//        TypedQuery<T> toReturn = type == null ? query : query.setLockMode(type);
//
//        applyQueryHints(toReturn);
//
//        return toReturn;
        return query;
    }

    private static void applyQueryHints(Query query) {

//        for (Map.Entry<String, Object> hint : getQueryHints().withFetchGraphs(em)) {
//            query.setHint(hint.getKey(), hint.getValue());
//        }
    }

//    private static QueryHints getQueryHints() {
//        return metadata == null ? QueryHints.NoHints.INSTANCE : DefaultQueryHints.of(entityInformation, metadata);
//    }

    private static boolean isUnpaged(Pageable pageable) {
        return pageable.isUnpaged();
    }

    private static <T> Page<T> readPage(TypedQuery<T> query, final Class<T> domainClass, Pageable pageable,
                                        @Nullable Specification<T> spec) {

        if (pageable.isPaged()) {
            query.setFirstResult((int) pageable.getOffset());
            query.setMaxResults(pageable.getPageSize());
        }

        return PageableExecutionUtils.getPage(query.getResultList(), pageable,
                () -> executeCountQuery(getCountQuery(spec, domainClass)));
    }

    private static long executeCountQuery(TypedQuery<Long> query) {

        Assert.notNull(query, "TypedQuery must not be null!");

        List<Long> totals = query.getResultList();
        long total = 0L;

        for (Long element : totals) {
            total += element == null ? 0 : element;
        }

        return total;
    }

    private static <T> TypedQuery<Long> getCountQuery(@Nullable Specification<T> spec, Class<T> domainClass) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);

        Root<T> root = applySpecificationToCriteria(spec, domainClass, query);

        if (query.isDistinct()) {
            query.select(builder.countDistinct(root));
        } else {
            query.select(builder.count(root));
        }

        // Remove all Orders the Specifications might have applied
        query.orderBy(Collections.<Order>emptyList());

        return em.createQuery(query);
    }


}
