package com.kafka.consumer;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Chris Chen
 * 2019/06/18
 * Explain:
 */

public class MyKafkaConsumer implements CommonConsts {
    private static CallBack callBack;
    private static Gson gson = new Gson();

    public static void main(String[] args) throws InterruptedException {
        consume();
    }

    /**
     * 开始消费
     */
    public static void consume() throws InterruptedException {
        KafkaConsumer<String, String> consumer = getConsumer();
        ConsumerRecords<String, String> consumerRecords = null;
        //循环接收
        while (true) {
            consumerRecords = consumer.poll(100);
            int size = consumerRecords.count();
            System.out.println("Got data set from kafkaMQ:" + size);

            if (size > 0) {
                consumerRecords.forEach(cr -> {
                    String value = cr.value();
                    //回调Spout的方法
//                    if (callBack != null) {
//                        callBack.receive(value);
//                    }
                    receive(value);
                });

            }

            Thread.sleep(1000);
            consumer.commitSync();//无回调
        }
    }

    public static KafkaConsumer<String, String> getConsumer() {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", KAFKA_URLS);
        //每个消费者分配独立的组号
        properties.put("group.id", KAFKA_GROUP_ID);
        //如果value合法，则自动提交偏移量
        properties.put("enable.auto.commit", "false");//不自动提交
        //设置多久一次更新被消费消息的偏移量
        properties.put("auto.commit.interval.ms", "1000");
        //设置会话响应的时间，超过这个时间kafka可以选择放弃消费或者消费下一条消息
        properties.put("session.timeout.ms", "30000");
        //自动重置offset
        properties.put("auto.offset.reset", "earliest");

        properties.put("key.deserializer", StringDeserializer.class.getName());
        properties.put("value.deserializer", StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Arrays.asList(KAFKA_TOPIC));
        return consumer;
    }

    public static void setCallBack(CallBack callBack) {
        MyKafkaConsumer.callBack = callBack;
    }

    public static void receive(String jsonStr) {
        System.out.println(jsonStr);
    }

    public interface CallBack {
        void receive(String jsonStr);
    }
}
