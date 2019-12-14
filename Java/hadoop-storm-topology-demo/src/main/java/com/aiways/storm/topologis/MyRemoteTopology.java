package com.aiways.storm.topologis;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyRemoteTopology extends BaseTopology {
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
//        testLocalhost();
        testRemoteHost();
    }

    private static void testRemoteHost() throws InvalidTopologyException, AuthorizationException, AlreadyAliveException, IOException {
        String topoName = "chrisTestTopo_05";
        Config config = new Config();
        config.put(Config.NIMBUS_HOST, NIMBUS_HOST);
        config.put(Config.NIMBUS_THRIFT_PORT, NIMBUS_THRIFT_PORT);
        config.put(Config.STORM_ZOOKEEPER_SERVERS, Arrays.asList(STORM_ZOOKEEPER_SERVERS));
        config.put(Config.STORM_ZOOKEEPER_PORT, STORM_ZOOKEEPER_PORT);
        config.setDebug(false);
        config.setNumWorkers(2);
    /*
        File jarFile = EJob.createTempJar(MyRemoteTopology.class.getClassLoader().getResource("").getPath());
        ClassLoader classLoader = EJob.getClassLoader();
        Thread.currentThread().setContextClassLoader(classLoader);
        //System.setProperty("storm.jar", jarFile.toString());
    */
        System.setProperty("storm.jar", "G:\\git\\WorkPlatForm\\WayLike\\AI-ways\\Ai-ways-power-libs\\HadoopStormTopology\\target\\hadoop-storm-topology-1.0-SNAPSHOT-jar-with-dependencies.jar");
//        System.setProperty("storm.jar", "G:\\git\\WorkPlatForm\\WayLike\\AI-ways\\Ai-ways-power-libs\\HadoopStormTopology\\target\\hadoop-storm-topology-1.0-SNAPSHOT.jar");
        StormSubmitter.submitTopology(topoName, config, new MyRemoteTopology().buildTopology());
    }

    private static void testLocalhost() {
        Config config = new Config();
        config.setDebug(true);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test3", config, new MyRemoteTopology().buildTopology());
        //Utils.sleep(1000 * 20);
        try {
            Thread.sleep(1000 * 20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        cluster.killTopology("test3");
//        cluster.shutdown();
    }

}
