package com.aiways.storm.datapro;

import java.util.List;

/**
 * Created by Chris Chen
 * 2019/02/19
 * Explain:放置集合的数据盒子
 */

public class DataBox<T> {
    private List<T> dataList;

    public DataBox() {
    }

    public DataBox(List<T> dataList) {
        this.dataList = dataList;
    }

    public static <T> DataBox create(List<T> dataList) {
        return new DataBox(dataList);
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
