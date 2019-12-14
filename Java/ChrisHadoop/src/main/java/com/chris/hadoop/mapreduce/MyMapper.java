package com.chris.hadoop.mapreduce;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by Chris Chen
 * 2018/12/14
 * Explain:
 */

public class MyMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String content = value.toString();
        System.out.println(content);
        String[] words = content.split("\t");//用一个tab分割
        for (String word : words) {
            context.write(new Text(word), new LongWritable(1L));//写入{"word",1}格式
        }
    }
}
