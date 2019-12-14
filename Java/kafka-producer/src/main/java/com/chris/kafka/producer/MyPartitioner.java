package com.chris.kafka.producer;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

/**
 * Create by Chris Chan
 * Create on 2019/6/18 15:58
 * Use for:
 */
public class MyPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        System.out.println(new Gson().toJson(key));
        int partition = Integer.parseInt(String.valueOf(key));
        return partition % 4;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
