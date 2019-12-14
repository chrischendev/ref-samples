package com.chris.hadoop.storm;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyBolts extends BaseRichBolt {
    private OutputCollector collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        System.out.println("有数据到");
        this.collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        System.out.println("处理数据");
        this.collector.emit(tuple, new Values(tuple.getString(0) + "!!!"));
        this.collector.ack(tuple);
    }

//    @Override
//    public void cleanup() {
//        System.out.println("资源释放");
//    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("data"));
    }
//
//    @Override
//    public Map<String, Object> getComponentConfiguration() {
//        return null;
//    }
}
