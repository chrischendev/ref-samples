package com.chris.kafka.producer;

import com.google.gson.Gson;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewPartitions;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Create by Chris Chan
 * Create on 2019/6/18 14:49
 * Use for: Kafka消息生产者
 */
public class MyKafkaProducer implements CommonConsts {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        produce();
    }

    private static void produce() {
        while (true) {
            List<KafkaMessage> messageList = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                messageList.add(KafkaMessage.create(String.format("%05d", i + 1), "来自星星的消息", LocalDateTime.now()));
            }
            send(messageList);
        }
    }

    private static void send(List<KafkaMessage> messageList) {
//        System.out.println("send data...");
        Producer<String, String> producer = getProducer();
        List<PartitionInfo> partitionInfos = producer.partitionsFor(KAFKA_TOPIC);
        System.out.println("partitionInfos: " + partitionInfos.size());
        String messageJson = gson.toJson(messageList);


        try {
            //producer.send(new ProducerRecord<>(KAFKA_TOPIC, new Random().nextInt(100) % 2, KAFKA_KEY + System.currentTimeMillis(), messageJson));
            producer.send(new ProducerRecord<>(KAFKA_TOPIC, "" + new Random().nextInt(100), messageJson));
        } catch (Exception e) {

        } finally {
            producer.close();
        }
    }

    //获取生产者
    private static Producer<String, String> getProducer() {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", KAFKA_URLS);
        properties.put("acks", "all");
        properties.put("retries", 0);
        properties.put("batch.size", 16384);
        properties.put("linger.ms", 1);
        properties.put("buffer.memory", 33554432);

        properties.put("max.request.size", 8388608);

        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());
        properties.put("partitioner.class", MyPartitioner.class.getName());

        AdminClient adminClient = AdminClient.create(properties);

        adminClient.createPartitions(Collections.singletonMap(KAFKA_TOPIC, NewPartitions.increaseTo(4)));

        return new KafkaProducer<>(properties);
    }

    private static void config() {
    }

}
