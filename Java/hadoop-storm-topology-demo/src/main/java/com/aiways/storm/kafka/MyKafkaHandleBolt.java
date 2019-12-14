package com.aiways.storm.kafka;

import com.aiways.storm.datapro.DataWriteUtils;
import com.aiways.storm.datapro.MessageBody;
import com.aiways.storm.datapro.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyKafkaHandleBolt extends BaseRichBolt {
    private OutputCollector collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        String jsonStr = tuple.getString(0);

        //解析json
        Type type = new TypeToken<List<User>>() {
        }.getType();
        List<User> userList = new Gson().fromJson(jsonStr, type);

        DataWriteUtils dataWriteUtils = new DataWriteUtils();
        dataWriteUtils.batchWriteToEs(userList);//持久化;

        //this.collector.emit(tuple, new Values(new MessageBody(userList)));
        //分流
        this.collector.emit("stream_print", new Values(new MessageBody(userList)));
        this.collector.emit("stream_print2", new Values(new MessageBody(userList)));

        //this.collector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        //outputFieldsDeclarer.declare(new Fields("data"));
        outputFieldsDeclarer.declareStream("stream_print", new Fields("data"));
        outputFieldsDeclarer.declareStream("stream_print2", new Fields("data"));
    }
}
