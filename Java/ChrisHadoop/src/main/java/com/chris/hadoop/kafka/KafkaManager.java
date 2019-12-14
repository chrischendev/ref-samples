package com.chris.hadoop.kafka;

/**
 * Created by Chris Chen
 * 2019/02/25
 * Explain:
 */

public class KafkaManager implements KafkaConsts {
    public static void main(String[] args) {
        deleteTopic();
    }

    public static void deleteTopic() {
        //topic对象
        KafkaTopicBean topic = new KafkaTopicBean();
        topic.setTopicName("power.monitor.collection.topic.dev");  //topic名称
        topic.setPartition(1);            //分区数量设置为1
        topic.setReplication(1);          //副本数量设置为1

        //创建topic
        //KafkaUtil.createKafaTopic(ZK_URL_1, topic);
        //删除topic
        KafkaUtil.deleteKafaTopic(ZK_URL_1, topic);

    }

}
