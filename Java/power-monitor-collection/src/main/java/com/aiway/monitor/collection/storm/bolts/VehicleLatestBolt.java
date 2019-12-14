package com.aiway.monitor.collection.storm.bolts;

import com.aiway.monitor.collection.model.DataPackage;
import com.aiway.monitor.collection.proxy.DataHandleProxy;
import com.power.monitor.libs.model.Vehicle;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 处理最新监控数据
 */
public class VehicleLatestBolt extends BaseRichBolt {
    private static Logger LOG = LoggerFactory.getLogger(VehicleLatestBolt.class);
    OutputCollector _collector;

    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        Object tupleValue = tuple.getValue(0);
        DataPackage dataPackage = (DataPackage) tupleValue;
        List<Vehicle> vehicleList = dataPackage.getDataList();

        //处理
        DataHandleProxy.get().processVehicleLatest(vehicleList);
        _collector.ack(tuple);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
}