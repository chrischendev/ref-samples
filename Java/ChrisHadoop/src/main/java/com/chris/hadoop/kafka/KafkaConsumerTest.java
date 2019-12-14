package com.chris.hadoop.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.clients.consumer.OffsetCommitCallback;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Chris Chen
 * 2018/12/27
 * Explain: 消息消费者
 */

public class KafkaConsumerTest implements KafkaConsts {
    public static void main(String[] args) {
        testConsume();
    }

    private static void testConsume() {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", BROKER_URL_1);
        //每个消费者分配独立的组号
        properties.put("group.id", GROUP_ID);
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
        //consumer.subscribe(Arrays.asList(TOPIC));
        consumer.subscribe(Arrays.asList(TOPICS[2]));
        //consumer.subscribe(Arrays.asList("storm.test.user.topic"));
        ConsumerRecords<String, String> consumerRecords=null;
        //循环接收
        while (true) {
            consumerRecords = consumer.poll(Duration.ofMillis(100));
            System.out.println("consumerRecords.count:" + consumerRecords.count());

            if (consumerRecords.count() > 0) {
                mockCallBackMethod(consumerRecords);
                //break;//收到消息就退出
            }
            //休眠
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //consumer.commitAsync();//无回调
            consumer.commitAsync(new OffsetCommitCallback() {
                @Override
                public void onComplete(Map<TopicPartition, OffsetAndMetadata> map, Exception e) {
                }
            });//有回调
        }
        //showConsumerRecords(consumerRecords);
    }

    //继续处理
    private static void showConsumerRecords(ConsumerRecords<String, String> consumerRecords) {
        consumerRecords.forEach(record -> System.out.printf("主题: %s, 偏移: %d, 键: %s, 值: %s\n", record.topic(), record.offset(), record.key(), record.value()));
    }

    //模拟回调
    private static void mockCallBackMethod(ConsumerRecords<String, String> consumerRecords) {
        //consumerRecords.forEach(record -> System.out.printf("topic: %s, offset: %d, key: %s, value: %s\n", record.topic(), record.offset(), record.key(), record.value()));
        consumerRecords.forEach(record -> System.out.println(record.value()));
    }
}
