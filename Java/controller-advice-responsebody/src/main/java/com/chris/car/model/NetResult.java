package com.chris.car.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Chris Chan
 * Create on 2019/12/30 1:59
 * Use for: 返回数据结构体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetResult<T> {
    private int code;
    private String msg;
    private T data;

    public static <T> NetResult create(int code, String msg, T data) {
        NetResult<Object> netResult = new NetResult<>();
        netResult.code = code;
        netResult.msg = msg;
        netResult.data = data;
        return netResult;
    }
}
