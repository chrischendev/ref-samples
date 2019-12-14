package com.aiway.monitor.collection.utils;

/**
 * Created by Chris Chen
 * 2019/03/05
 * Explain: 运行参数
 */

public class MainParams {
    private String env = "dev";
    private String topoName = "power.monitor.collection.topic.dev";


    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getTopoName() {
        return topoName;
    }

    public void setTopoName(String topoName) {
        this.topoName = topoName;
    }
}
