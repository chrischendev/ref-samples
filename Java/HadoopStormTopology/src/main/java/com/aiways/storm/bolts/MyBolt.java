package com.aiways.storm.bolts;

import com.aiways.storm.datapro.DataWriteUtils;
import com.google.gson.Gson;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.List;
import java.util.Map;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyBolt extends BaseRichBolt {
    private OutputCollector collector;
    private int count = 0;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        System.out.println("有数据到");
        this.collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        String names = tuple.getString(0);
        List<String> nameList = (List<String>) tuple.getValueByField("nameList");
        System.out.println("MyBolt打印数据 Tuple: " + new Gson().toJson(tuple.getFields()));

        new DataWriteUtils().batchWriteStrListToTxtFile(nameList);

        System.out.println("打印处理数据 " + nameList.size());
        this.collector.emit(tuple, new Values(names));

        //this.collector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("data"));
    }
}
