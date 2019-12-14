package com.chris.mybatis;

import com.chris.mybatis.model.orm.ReceiptEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * MybatisDemo
 * com.chris.mybatis
 * Created by Chris Chen
 * 2018/6/12
 * Explain:
 */
@Mapper
@Component
public interface ReceiptMapper {
    @Select("select * from ydx_receipts where id=#{id}")
    ReceiptEntity get(@Param("id") Integer id);
}
