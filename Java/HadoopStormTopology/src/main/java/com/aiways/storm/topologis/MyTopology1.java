package com.aiways.storm.topologis;

import com.aiways.storm.bolts.MyBolt;
import com.aiways.storm.bolts.PrintBolt;
import com.aiways.storm.spouts.MySpout;
import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.AlreadyAliveException;
import org.apache.storm.generated.AuthorizationException;
import org.apache.storm.generated.InvalidTopologyException;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

import java.util.Arrays;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyTopology1 {
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


    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        testLocalhost();
//        testRemoteHost();
    }

    private static void testRemoteHost() throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("data", new MySpout());
        builder.setBolt("handle", new MyBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("data");
        builder.setBolt("print", new PrintBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("handle");

        Config config = new Config();
        config.put(Config.NIMBUS_HOST, NIMBUS_HOST);
        config.put(Config.NIMBUS_THRIFT_PORT, NIMBUS_THRIFT_PORT);
        config.put(Config.STORM_ZOOKEEPER_SERVERS, Arrays.asList(STORM_ZOOKEEPER_SERVERS));
        config.put(Config.STORM_ZOOKEEPER_PORT, STORM_ZOOKEEPER_PORT);
        config.setDebug(true);
        config.setNumWorkers(3);

        System.setProperty("storm.jar","d:\\storm-remote-submit-1.0-SNAPSHOT-jar-with-dependencies.jar");
        StormSubmitter.submitTopology("chrisTestTopology", config, builder.createTopology());
    }

    private static void testLocalhost() {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("data", new MySpout());
        builder.setBolt("pro", new MyBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("data");
        builder.setBolt("print", new PrintBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("pro");

        Config config = new Config();
        config.setDebug(true);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test3", config, builder.createTopology());
        Utils.sleep(1000 * 20);
        cluster.killTopology("test3");
        cluster.shutdown();
    }
}
