package com.aiways.storm.bolts;

import com.google.gson.Gson;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class PrintBolt extends BaseRichBolt {
    private static Logger LOG = LoggerFactory.getLogger(PrintBolt.class);
    OutputCollector _collector;

    @Override
    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        _collector = collector;
    }

    @Override
    public void execute(Tuple tuple) {
        //System.out.println("打印数据: " + tuple.getString(0));
        System.out.println("PrintBolt打印数据 Tuple: " + new Gson().toJson(tuple.getFields()));
        _collector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
}