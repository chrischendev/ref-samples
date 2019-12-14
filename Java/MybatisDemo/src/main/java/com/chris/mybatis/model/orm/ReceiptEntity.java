package com.chris.mybatis.model.orm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * MybatisDemo
 * com.chris.mybatis.model.orm
 * Created by Chris Chen
 * 2018/6/12
 * Explain:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ydx_receipts")
public class ReceiptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Byte receiptType;
    private String title;
    private String identityNo;
    private String cell;
    private String email;
    private String description;
}
