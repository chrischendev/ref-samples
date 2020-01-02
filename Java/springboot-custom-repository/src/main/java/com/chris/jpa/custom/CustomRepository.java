package com.chris.jpa.custom;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Collection;
import java.util.List;

/**
 * Create by Chris Chan
 * Create on 2020/1/2 18:38
 * Use for: 自定义Repository
 */
@NoRepositoryBean
public interface CustomRepository<T, ID> extends JpaRepository<T, ID> {
    Integer getLastInsertId();//获取最后插入的记录的Id

    PageData<T> getPage(Pageable pageable);//获取自定义分页

    boolean batchSave(T[] datas);//批量写入 数组

    boolean batchSave(Collection<T> dataCollection);//批量写入 集合

    boolean batchSave(T[] datas, int batchSize);//分批写入 数组

    boolean batchSave(Collection<T> dataCollection, int batchSize);//分批写入 集合

    boolean batchSaveList(List<T> dataList, int batchSize);//分批写入 List
}
