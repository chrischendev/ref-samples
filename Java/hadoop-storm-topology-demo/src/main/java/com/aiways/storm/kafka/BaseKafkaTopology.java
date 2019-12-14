package com.aiways.storm.kafka;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.generated.StormTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.utils.Utils;

/**
 * Created by Chris Chen
 * 2019/01/31
 * Explain:
 */

public class BaseKafkaTopology {
    protected StormTopology buildTopology() {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("data", new MyKafkaSpout());
        builder.setBolt("handle", new MyKafkaHandleBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("data");
        builder.setBolt("print", new MyKafkaPrintBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("handle", "stream_print");
        builder.setBolt("stream_print", new MyKafkaStreamBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("handle", "stream_print2");
        return builder.createTopology();
    }

    public static void main(String[] args) throws Exception {
        BaseKafkaTopology topo = new BaseKafkaTopology();
        Config conf = new Config();
        conf.setDebug(false);

        if (args != null && args.length > 0) {
            conf.setNumWorkers(3);
            StormSubmitter.submitTopology(args[0], conf, topo.buildTopology());
        } else {
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology("testLocal", conf, topo.buildTopology());
            Utils.sleep(100000);
            cluster.killTopology("testLocal");
            cluster.shutdown();
        }
    }
}
