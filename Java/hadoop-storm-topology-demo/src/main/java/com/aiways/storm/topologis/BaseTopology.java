package com.aiways.storm.topologis;

import com.aiways.storm.bolts.MyBolt;
import com.aiways.storm.bolts.PrintBolt;
import com.aiways.storm.spouts.MySpout;
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

public class BaseTopology {
    protected StormTopology buildTopology() {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("data", new MySpout());
        builder.setBolt("handle", new MyBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("data");
        builder.setBolt("print", new PrintBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping("handle");

        return builder.createTopology();
    }

    public static void main(String[] args) throws Exception {
        BaseTopology topo = new BaseTopology();
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
