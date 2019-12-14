package com.aiways.storm.kafka1;

import com.aiways.storm.kafka.KafkaConsts;
import com.aiways.storm.topologis.BaseTopology;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.kafka.*;
import org.apache.storm.kafka.bolt.KafkaBolt;
import org.apache.storm.spout.SchemeAsMultiScheme;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

import java.io.IOException;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyKafkaTopology1 extends BaseTopology implements KafkaConsts {
    private static final String NIMBUS_HOST_IP = "10.100.81.177";
    private static final String NIMBUS_HOST = "node5.aiwaystack.com";
    private static final String[] NIMBUS_HOSTS = {
            "node5.aiwaystack.com",
            "node6.aiwaystack.com",
            "node7.aiwaystack.com"
    };
    private static final String[] NIMBUS_HOSTS_IP = {
            "10.100.81.177",
            "10.100.81.178",
            "10.100.81.179"
    };
    private static final int NIMBUS_THRIFT_PORT = 6627;
    private static final String[] STORM_ZOOKEEPER_SERVERS = {
            "node5.aiwaystack.com",
            "node6.aiwaystack.com",
            "node7.aiwaystack.com"
    };
    private static final String[] STORM_ZOOKEEPER_SERVERS_IP = {
            "10.100.81.177",
            "10.100.81.178",
            "10.100.81.179"
    };
    private static final int STORM_ZOOKEEPER_PORT = 2181;

    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException, IOException {
        testLocalhostForKafka();
    }

    private static void testLocalhostForKafka() {
        // 配置Zookeeper地址
        BrokerHosts brokerHosts = new ZkHosts(STORM_ZOOKEEPER_SERVERS[0] + ":" + STORM_ZOOKEEPER_PORT);
        // 配置Kafka订阅的Topic，以及zookeeper中数据节点目录和名字
        SpoutConfig spoutConfig = new SpoutConfig(brokerHosts, TOPIC, "/zkkafkaspout", "kafkaspout");

        // 配置KafkaBolt中的kafka.broker.properties
        Config conf = new Config();
        /*
        Properties properties = new Properties();
        // 配置Kafka broker地址
        //properties.put("metadata.broker.list", BROKER_URLS[0]);
        properties.put("bootstrap.servers", BROKER_URLS[0]);
        // serializer.class为消息的序列化类
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");

        conf.put("kafka.broker.properties", properties);
        */
        //conf.put("bootstrap.servers", BROKER_URLS[0]);
        // 配置KafkaBolt生成的topic
        conf.put("topic", TOPIC);

        spoutConfig.scheme = new SchemeAsMultiScheme(new StringScheme());
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("data", new KafkaSpout(spoutConfig));
        builder.setBolt("bolt", new MyKafkaBolt1(), 1).shuffleGrouping("data");
        builder.setBolt("kafkabolt", new KafkaBolt(), 1).shuffleGrouping("bolt");

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test3", conf, builder.createTopology());
        Utils.sleep(1000 * 20);
        cluster.killTopology("test3");
        cluster.shutdown();
    }
}
