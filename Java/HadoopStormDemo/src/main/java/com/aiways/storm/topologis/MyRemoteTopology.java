package com.aiways.storm.topologis;

import com.aiways.storm.utils.EJob;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyRemoteTopology extends BaseTopology {
    private static final String NIMBUS_HOST = "10.100.81.177";
    private static final String[] NIMBUS_HOSTS = {
            "10.100.81.177",
            "10.100.81.178",
            "10.100.81.179"
    };
    private static final int NIMBUS_THRIFT_PORT = 6627;
    private static final String[] STORM_ZOOKEEPER_SERVERS = {
            "10.100.81.177",
            "10.100.81.178",
            "10.100.81.179"
    };
    private static final int STORM_ZOOKEEPER_PORT = 2181;

    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException, IOException {
        testLocalhost();
//        testRemoteHost();
    }

    private static void testRemoteHost() throws InvalidTopologyException, AuthorizationException, AlreadyAliveException, IOException {
        String topoName = "chrisTestTopology6";
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
        System.setProperty("storm.jar","G:\\git\\WorkPlatForm\\WayLike\\AI-ways\\Ai-ways-power-libs\\HadoopStormDemo\\target\\hadoop-storm-demo-0.0.1-SNAPSHOT.jar");
        StormSubmitter.submitTopology(topoName, config, new MyRemoteTopology().buildTopology());
    }

    private static void testLocalhost() {
        Config config = new Config();
        config.setDebug(true);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test3", config, new MyRemoteTopology().buildTopology());
        Utils.sleep(1000 * 20);
        cluster.killTopology("test3");
        cluster.shutdown();
    }
}
