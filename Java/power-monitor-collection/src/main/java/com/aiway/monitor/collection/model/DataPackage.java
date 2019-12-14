package com.aiway.monitor.collection.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Chris Chen
 * 2019/02/02
 * Explain:
 */

public class DataPackage<T> implements Serializable {
    private List<T> dataList;

    public DataPackage() {
    }

    public DataPackage(List<T> dataList) {
        this.dataList = dataList;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
