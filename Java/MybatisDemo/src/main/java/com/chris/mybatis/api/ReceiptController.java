package com.chris.mybatis.api;

import com.chris.mybatis.ReceiptMapper;
import com.chris.mybatis.model.orm.ReceiptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MybatisDemo
 * com.chris.mybatis.api
 * Created by Chris Chen
 * 2018/6/12
 * Explain:
 */
@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    @Autowired
    ReceiptMapper receiptMapper;

    @RequestMapping("/get")
    public ReceiptEntity get(Integer id) {
        return receiptMapper.get(id);
    }
}
