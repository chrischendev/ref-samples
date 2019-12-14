package com.aiways.storm.kafka;

import com.google.gson.Gson;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;
import org.apache.storm.utils.Utils;

import java.util.Map;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyKafkaSpout extends BaseRichSpout {
    private SpoutOutputCollector collector;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        System.out.println("打开数据源");
        this.collector = spoutOutputCollector;
    }

    @Override
    public void nextTuple() {
        Utils.sleep(500);

        KafkaUtils kafkaUtils = new KafkaUtils();
        kafkaUtils.setCallBack(new KafkaUtils.CallBack() {
            @Override
            public void receive(String jsonStr) {
                collector.emit(new Values(jsonStr));
            }
        });//kafka收到消息的回调处理
        kafkaUtils.startConsume();//开始消费
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("data"));
    }
}
