package com.aiways.storm.kafka;

/**
 * Created by Chris Chen
 * 2018/12/27
 * Explain:常量
 */

public interface KafkaConsts {
    String[] BROKER_URLS = {
            "10.100.81.177:9092",
            "10.100.81.178:9092",
            "10.100.81.179:9092"
    };
    String TOPIC = "storm.test.user.topic";
    String KEY = "chris-key";
    String GROUP_ID = "group-2";
}
