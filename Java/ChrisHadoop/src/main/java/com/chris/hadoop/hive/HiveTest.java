package com.chris.hadoop.hive;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chris Chen
 * 2018/12/11
 * Explain:
 */

public class HiveTest {
    public static void main(String[] args) throws IOException {
        System.setProperty("hadoop.home.dir", "D:\\softs\\hadoop-2.8.5");//HADOOP_HOME
        BasicConfigurator.configure();//自动快速地使用缺省Log4j环境

        //todo
        test1();
    }

    private static void test1() {

    }


}
