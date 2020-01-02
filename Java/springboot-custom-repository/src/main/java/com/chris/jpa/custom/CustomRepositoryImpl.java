package com.chris.jpa.custom;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2020/1/2 18:42
 * Use for:
 */
public class CustomRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {
    private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    @Override
    public Integer getLastInsertId() {
        Object result = entityManager.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
        return Integer.valueOf(String.valueOf(result));
    }

    /**
     * 获取自定义分页
     *
     * @param pageable
     * @return
     */
    @Override
    public PageData<T> getPage(Pageable pageable) {
        PageData<T> pageData = new PageData<T>(pageable.getPageNumber() + 1, pageable.getPageSize());
        pageData.count = count();
        pageData.hasNext = pageData.page * pageData.pageSize < pageData.count;//是否有下一页
        pageData.dataList = findAll(pageable).getContent();
        return pageData;
    }

    @Override
    public boolean batchSave(T[] datas) {
        return batchSave(Arrays.asList(datas));
    }

    @Override
    public boolean batchSave(Collection<T> dataCollection) {
        if (CollectionUtils.isEmpty(dataCollection)) {
            return false;
        }
        dataCollection.stream().forEach(data -> {
            entityManager.persist(data);
        });
        entityManager.flush();
        entityManager.clear();
        return true;
    }

    @Override
    public boolean batchSave(T[] datas, int batchSize) {
        return batchSave(Arrays.asList(datas), batchSize);
    }

    @Override
    public boolean batchSave(Collection<T> dataCollection, int batchSize) {
        if (CollectionUtils.isEmpty(dataCollection)) {
            return false;
        }
        long count = 0;//计数器
        for (T data : dataCollection) {
            entityManager.persist(data);
            count++;
            if (count >= batchSize) {
                entityManager.flush();
                entityManager.clear();
                count = 0;//计数器归零
            }
        }
        //提交零头
        if (count > 0) {
            entityManager.flush();
            entityManager.clear();
        }
        return true;
    }

    @Override
    public boolean batchSaveList(List<T> dataList, int batchSize) {
        int size = dataList.size();
        for (int i = 0; i < size; i += batchSize) {
            int toIndex = size - i < batchSize ? i + size - i : i + batchSize;
            dataList.subList(i, toIndex).stream().forEach(entity -> entityManager.persist(entity));
            entityManager.flush();
            entityManager.clear();
        }
        return true;
    }
}
