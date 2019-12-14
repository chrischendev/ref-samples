package com.chris.hadoop.storm;

import com.chris.hadoop.storm.test.PrintBolt;
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

public class StormMainTest {
    private static final String str1 = "test1";
    private static final String str2 = "test2";

    private static final String NIMBUS_HOST = "10.100.81.177";
    private static final int NIMBUS_THRIFT_PORT = 6627;
    private static final String[] STORM_ZOOKEEPER_SERVERS = {
            "10.100.81.177",
            "10.100.81.178",
            "10.100.81.179"
    };
    private static final int STORM_ZOOKEEPER_PORT = 2181;


    public static void main(String[] args) throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        testLocalhost();
    }

    private static void testRemoteHost() throws InvalidTopologyException, AuthorizationException, AlreadyAliveException {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("data", new MySpouts());
        builder.setBolt("handle", new MyBolts(), 1)
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

//        System.setProperty("storm.jar","d:\\storm-remote-submit-1.0-SNAPSHOT-jar-with-dependencies.jar");
        StormSubmitter.submitTopology("chrisTestTopology", config, builder.createTopology());
    }

    private static void testLocalhost() {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("data", new MySpouts());
        builder.setBolt("pro", new MyBolts(), 1)
                .setNumTasks(1)
                .shuffleGrouping("data");
        builder.setBolt("print", new PrintBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("pro");

        Config config = new Config();
        //config.put("name", "chris chen");
        config.setDebug(true);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("test3", config, builder.createTopology());
        Utils.sleep(1000 * 20);
        cluster.killTopology("test3");
        cluster.shutdown();
    }

    private static void testStorm(String[] args) {
        //定义一个拓扑
        TopologyBuilder builder = new TopologyBuilder();
        //设置一个Executeor(线程)，默认一个
        builder.setSpout(str1, new MySpouts());
        //设置一个Executeor(线程)，和一个task
        builder.setBolt(str2, new MyBolts(), 1).setNumTasks(1).shuffleGrouping(str1);
        Config conf = new Config();
        conf.put("test", "test");
        try {
            //运行拓扑
            if (args != null && args.length > 0) { //有参数时，表示向集群提交作业，并把第一个参数当做topology名称
                System.out.println("远程模式");
                StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
            } else {//没有参数时，本地提交
                //启动本地模式
                System.out.println("本地模式");
                LocalCluster cluster = new LocalCluster();
                cluster.submitTopology("111", conf, builder.createTopology());
                Thread.sleep(10000);
                //  关闭本地集群
                cluster.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
