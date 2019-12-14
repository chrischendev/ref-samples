package com.chris.hadoop.kafka;

/**
 * Created by Chris Chen
 * 2018/12/27
 * Explain:常量
 */

public interface KafkaConsts {
    String BROKER_URL_1 = "10.100.81.177:9092";
    String BROKER_URL_2 = "10.100.81.178:9092";
    String BROKER_URL_3 = "10.100.81.179:9092";

    String ZK_URL_1 = "10.100.81.177:2181";
    String ZK_URL_2 = "10.100.81.178:2181";
    String ZK_URL_3 = "10.100.81.179:2181";

    //String TOPIC = "chris-topic";
    String TOPIC = "power.monitor.collection.topic";
    String[] TOPICS = {
            "power.monitor.collection.topic.dev",//本地环境
            "power.monitor.collection.topic.dev.tmp",//开发环境
            "power.monitor.collection.topic.test",//测试环境
    };
    String KEY = "chris-key";
    String GROUP_ID = "power.monitor.collection.group";
}
