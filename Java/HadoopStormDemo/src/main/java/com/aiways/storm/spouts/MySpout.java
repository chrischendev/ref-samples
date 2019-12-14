package com.aiways.storm.spouts;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;
import java.util.Random;

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

//    @Override
//    public void close() {
//        System.out.println("关闭");
//    }
//
//    @Override
//    public void activate() {
//        System.out.println("激活");
//    }
//
//    @Override
//    public void deactivate() {
//        System.out.println("反激活");
//    }

    @Override
    public void nextTuple() {
        Utils.sleep(500);
        System.out.println("发送数据");
        final String[] words = new String[]{"陈凯利", "孙菲菲", "姚诗涵", "刘德华", "chris"};
        final Random rand = new Random();
        final String word = words[rand.nextInt(words.length)];
        this.collector.emit(new Values(word));//发送元组
    }

//    @Override
//    public void ack(Object o) {
//        System.out.println("成功");
//    }
//
//    @Override
//    public void fail(Object o) {
//        System.out.println("失败");
//    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("data"));
    }

//    @Override
//    public Map<String, Object> getComponentConfiguration() {
//        return null;
//    }
}
