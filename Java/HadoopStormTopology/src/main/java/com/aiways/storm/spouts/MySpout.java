package com.aiways.storm.spouts;

import com.google.gson.Gson;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MySpout extends BaseRichSpout {
    private SpoutOutputCollector collector;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        System.out.println("打开数据源");
        this.collector = spoutOutputCollector;
    }

    @Override
    public void nextTuple() {
        final String[] names1 = new String[]{"飞燕女", "燕山雪", "俏千金", "狐美人", "虎头怪"};
        final String[] names2 = new String[]{"刘德华", "古天乐", "周润发"};
        this.collector.emit(new Values(new Gson().toJson(names1), new Gson().toJson(names2), Arrays.asList(names1)));//发送元组
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("names1", "names2", "nameList"));
    }
}
