package com.aiway.monitor.collection.kafka;

/**
 * Created by Chris Chen
 * 2018/12/27
 * Explain:常量
 */

public interface KafkaConsts {
    String[] KAFKA_BROKER_URLS = {
            "node5.aiwaystack.com:9092",
            "node6.aiwaystack.com:9092",
            "node7.aiwaystack.com:9092"
    };
    String[] KAFKA_BROKER_IPS = {
            "10.100.81.177:9092",
            "10.100.81.178:9092",
            "10.100.81.179:9092"
    };
    String[] KAFKA_TOPICS = {
            "power.monitor.collection.topic.dev",//本地环境
            "power.monitor.collection.topic.dev",//开发环境
            "power.monitor.collection.topic.test",//测试环境
    };
    String KEY = "power.monitor.collection.key";
    String GROUP_ID = "power.monitor.collection.group";
}
