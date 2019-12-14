package com.aiways.storm.kafka1;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain:
 */

public class MyKafkaBolt1 extends BaseBasicBolt {
    private OutputCollector collector;

    @Override
    public void execute(Tuple input, BasicOutputCollector collector) {
        String word = (String) input.getValue(0);
        String out = "I'm " + word +  "!";
        System.out.println("out=" + out);
        collector.emit(new Values(out));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("data"));
    }
}
