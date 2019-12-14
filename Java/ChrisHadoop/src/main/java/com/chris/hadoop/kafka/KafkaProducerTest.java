package com.chris.hadoop.kafka;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * Created by Chris Chen
 * 2018/12/27
 * Explain: 消息生产者
 */

public class KafkaProducerTest implements KafkaConsts {
    public static void main(String[] args) {
        mockUsers();
    }

    private static void testProduce() {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", BROKER_URL_1);

        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);

        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<>(properties);
            for (int i = 0; i < 10; i++) {
                String k = String.format("%02d", i + 1);
                String msg = "chris'kafka 测试消息 " + k;
                producer.send(new ProducerRecord<>(TOPIC, "key_" + k, msg));
            }
        } catch (Exception e) {

        } finally {
            producer.close();
        }
    }

    private static void mockUsers() {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", BROKER_URL_1);

        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);

        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        Producer<String, String> producer = null;

        //String[] names = new String[]{"飞燕女", "燕山雪", "俏千金", "狐美人", "虎头怪", "牛魔王"};
        String[] names = new String[]{"刘德华", "古天乐", "周润发", "陈道明", "陈慧琳", "周星驰"};
        try {
            producer = new KafkaProducer<>(properties);
            for (int i = 0, len = names.length; i < len * 10; i++) {
                String k = String.format("%02d", i + 1);
                String msg = new Gson().toJson(new User(names[i % len], 30 + i));
                System.out.println(msg);
                producer.send(new ProducerRecord<>("storm.test.user.topic", "key_" + k, msg));
            }
        } catch (Exception e) {

        } finally {
            producer.close();
        }
    }
}
