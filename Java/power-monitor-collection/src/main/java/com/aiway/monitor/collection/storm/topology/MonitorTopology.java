package com.aiway.monitor.collection.storm.topology;

import com.aiway.monitor.collection.consts.AppCommonConsts;
import com.aiway.monitor.collection.kafka.KafkaConsts;
import com.aiway.monitor.collection.proxy.DataHandleProxy;
import com.aiway.monitor.collection.utils.MainParams;
import com.aiway.monitor.collection.utils.MainParamsUtils;
import com.aiways.monitor.collection.business.consts.CommonConsts;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.utils.Utils;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:  主拓扑
 */

public class MonitorTopology extends BaseMonitorTopology implements KafkaConsts {
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
    private static String topoName = CommonConsts.TOPO_NAME;

    public static void main(String[] args) throws IOException, AuthorizationException, AlreadyAliveException, InvalidTopologyException {
        MainParams mainParams = MainParamsUtils.parse(args);

        System.out.println("Env: " + mainParams.getEnv());
        System.out.println("TopoName: " + mainParams.getTopoName());

//        System.out.println("TopoName: " + MonitorTopology.topoName);
//        System.out.println("EnvIndex: " + AppCommonConsts.ENV_INDEX);
//        System.out.println("Kafka.broker.url: " + KAFKA_BROKER_IPS[0]);
//        System.out.println("Kafka.Topic: " + KafkaConsts.KAFKA_TOPICS[AppCommonConsts.ENV_INDEX]);
//        System.out.println("Es.URL: " + DataHandleProxy.ES_URLS[AppCommonConsts.ENV_INDEX]);

//        testLocalhostForKafka();//本地模式
//        testRemoteHostForKafka();//远程模式 提交
    }

    private static void testLocalhostForKafka() {
        Config config = new Config();
        config.setDebug(true);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology(MonitorTopology.topoName, config, new MonitorTopology().buildTopology());
        Utils.sleep(1000 * 10);
    }

    private static void testRemoteHostForKafka() throws InvalidTopologyException, AuthorizationException, AlreadyAliveException, IOException {
        String topoName = CommonConsts.TOPO_NAME;
        Config config = new Config();
        config.put(Config.NIMBUS_HOST, NIMBUS_HOST);
        config.put(Config.NIMBUS_THRIFT_PORT, NIMBUS_THRIFT_PORT);
        config.put(Config.STORM_ZOOKEEPER_SERVERS, Arrays.asList(STORM_ZOOKEEPER_SERVERS));
        config.put(Config.STORM_ZOOKEEPER_PORT, STORM_ZOOKEEPER_PORT);
        config.setDebug(false);
        config.setNumWorkers(2);

//        System.setProperty("storm.jar", "G:\\git\\WorkPlatForm\\WayLike\\AI-ways\\Ai-ways-power-libs\\HadoopStormTopology\\target\\hadoop-storm-topology-1.0-SNAPSHOT-jar-with-dependencies.jar");
        System.setProperty("storm.jar", "G:\\git\\WorkPlatForm\\WayLike\\AI-ways\\Ai-ways-power-libs\\HadoopStormTopology\\target\\hadoop-storm-topology-1.0-SNAPSHOT.jar");
        StormSubmitter.submitTopology(topoName, config, new MonitorTopology().buildTopology());
    }
}
