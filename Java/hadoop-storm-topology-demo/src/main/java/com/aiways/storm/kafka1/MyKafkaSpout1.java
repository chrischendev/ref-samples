package com.aiways.storm.kafka1;

import org.apache.storm.kafka.KafkaSpout;
import org.apache.storm.kafka.SpoutConfig;

/**
 * Created by Chris Chen
 * 2019/02/01
 * Explain:
 */

public class MyKafkaSpout1 extends KafkaSpout {
    public MyKafkaSpout1(SpoutConfig spoutConf) {
        super(spoutConf);
    }
}
