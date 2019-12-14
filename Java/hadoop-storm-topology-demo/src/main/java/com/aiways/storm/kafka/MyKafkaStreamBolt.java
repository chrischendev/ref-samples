package com.aiways.storm.kafka;

import com.aiways.storm.datapro.MessageBody;
import com.aiways.storm.datapro.User;
import com.google.gson.Gson;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class MyKafkaStreamBolt extends BaseRichBolt {
    private static Logger LOG = LoggerFactory.getLogger(MyKafkaStreamBolt.class);
    OutputCollector _collector;

    public void prepare(Map conf, TopologyContext context, OutputCollector collector) {
        _collector = collector;
    }

    public void execute(Tuple tuple) {
        Object tupleValue = tuple.getValue(0);
        MessageBody messageBody = (MessageBody) tupleValue;
        List<User> userList = messageBody.getUserList();

        LOG.info("分流数据打印: " + new Gson().toJson(userList));
        _collector.ack(tuple);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    }
}