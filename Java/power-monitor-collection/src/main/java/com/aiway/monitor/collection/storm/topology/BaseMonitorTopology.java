package com.aiway.monitor.collection.storm.topology;

import com.aiway.monitor.collection.storm.bolts.*;
import com.aiway.monitor.collection.storm.consts.BoltIds;
import com.aiway.monitor.collection.storm.consts.SpoutIds;
import com.aiway.monitor.collection.storm.consts.StreamIds;
import com.aiway.monitor.collection.storm.spouts.VehicleVMSpout;
import com.aiways.monitor.collection.business.consts.CommonConsts;
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

public class BaseMonitorTopology implements SpoutIds, BoltIds, StreamIds {
    protected StormTopology buildTopology() {
        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout(DATA_INPUT, new VehicleVMSpout());
        builder.setBolt(DATA_HANDLE, new DataHandleBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping(DATA_INPUT);
        //分流处理
        //1. vehicle
        builder.setBolt(VEHICLE, new VehicleBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping(DATA_HANDLE, VEHICLE);
        //2. vehicle_latest
        builder.setBolt(VEHICLE_LATEST, new VehicleLatestBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping(DATA_HANDLE, VEHICLE_LATEST);
        //3. vehicle_last_day
        builder.setBolt(VEHICLE_LAST_DAY, new VehicleLastdayBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping(DATA_HANDLE,VEHICLE_LAST_DAY);
        //4. battery_warning
        builder.setBolt(BATTERY_WARNING, new BatteryWarningBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping(DATA_HANDLE,BATTERY_WARNING);
        //5. battery_alert
        builder.setBolt(BATTERY_ALERT, new BatteryAlertBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping(DATA_HANDLE,BATTERY_ALERT);
        //6. fault_count
        builder.setBolt(FAULT_COUNT, new FaultCountBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping(DATA_HANDLE,FAULT_COUNT);
        //7. charge_data
        builder.setBolt(CHARGE_DATA, new ChargeDataBolt(), 1)
                .setNumTasks(1)
                .shuffleGrouping(DATA_HANDLE,CHARGE_DATA);

        return builder.createTopology();
    }

    public static void main(String[] args) throws Exception {
        BaseMonitorTopology topo = new BaseMonitorTopology();
        Config conf = new Config();
        conf.setDebug(false);

        if (args != null && args.length > 0) {
            conf.setNumWorkers(3);
            StormSubmitter.submitTopology(args[0], conf, topo.buildTopology());
        } else {
            LocalCluster cluster = new LocalCluster();
            cluster.submitTopology(CommonConsts.TOPO_NAME, conf, topo.buildTopology());
            Utils.sleep(100000);
            cluster.killTopology(CommonConsts.TOPO_NAME);
            cluster.shutdown();
        }
    }
}
