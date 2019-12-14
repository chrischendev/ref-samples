package com.aiway.monitor.collection.kafka;

import com.aiway.monitor.collection.consts.AppCommonConsts;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.storm.utils.Utils;

import java.util.Arrays;
import java.util.Properties;

/**
 * Created by Chris Chen
 * 2019/02/01
 * Explain:
 */

public class KafkaUtils implements AppCommonConsts, KafkaConsts {
    private CallBack callBack;
    private static Gson gson;

    static {
        gson = new Gson();
    }

    /**
     * 开始消费
     */
    public void startConsume() {
        Properties properties = new Properties();

        properties.put("bootstrap.servers", KAFKA_BROKER_IPS[0]);
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
        consumer.subscribe(Arrays.asList(KAFKA_TOPICS[ENV_INDEX]));
        //consumer.subscribe("storm.test.user.topic");
        ConsumerRecords<String, String> consumerRecords = null;
        //循环接收
        while (true) {
            consumerRecords = consumer.poll(100);
            int size = consumerRecords.count();
            System.out.println("Got data set from kafkaMQ:" + size);

            if (size > 0) {
                //把consumerRecords解析构建为List<User>
                consumerRecords.forEach(cr -> {
                    String value = cr.value();
                    //回调Spout的方法
                    if (callBack != null) {
                        callBack.receive(value);
                    }
                });

            }

            Utils.sleep(1 * 1000);
            consumer.commitSync();//无回调
        }
    }

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public interface CallBack {
        void receive(String jsonStr);
    }
}
