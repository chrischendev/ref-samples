package com.chris.hadoop.mapreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by Chris Chen
 * 2018/12/14
 * Explain:
 */


public class MyReducer extends Reducer<Text, LongWritable, Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        System.out.println("comecomecomecomecomecome~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        long times = 0L;//次数
        for (LongWritable value : values) {
            times += value.get();//累加
        }
        System.out.println(key.toString() + " " + times);
        context.write(key, new LongWritable(times));
    }
}
