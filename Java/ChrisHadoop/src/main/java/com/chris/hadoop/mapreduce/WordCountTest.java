package com.chris.hadoop.mapreduce;

import com.chris.hadoop.hdfs.HdfsUtils;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;

/**
 * Created by Chris Chen
 * 2018/12/11
 * Explain:
 */

public class WordCountTest {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        System.setProperty("hadoop.home.dir", "D:\\softs\\hadoop-2.8.5");//HADOOP_HOME
        BasicConfigurator.configure();//自动快速地使用缺省Log4j环境

        //todo
        test1();
    }

    private static void test2() throws IOException {
        FileSystem fs = HdfsUtils.getFileSystem();

        String inputPath = "/wordcount_input";
        String outputPath = "/wordcount_output";
        String log_file_src = "/chris_log_src.txt";
        String log_file_dst = "/chris_log_dst.txt";

        Path inputLogPath = new Path(inputPath + log_file_src);
        Path outputLogPath = new Path(outputPath + log_file_dst);

        //8. 下载文件查看结果
        fs.copyToLocalFile(outputLogPath, new Path("I:/com_log.txt"));
        //fs.delete(outputLogPath);
    }

    private static void test1() throws IOException, ClassNotFoundException, InterruptedException {
        FileSystem fs = HdfsUtils.getFileSystem();

        String log_file_src = "/chris_log_src.txt";
        String log_file_dst = "/chris_log_dst.txt";
        String inputLocalPath = "I:";
        String inputPath = "/wordcount_input";
        String outputPath = "/wordcount_output";


        //上传原始日志文件
        Path localLogPath = new Path(inputLocalPath + log_file_src);
        Path inputLogPath = new Path(inputPath + log_file_src);
        Path srcPath = new Path(inputPath);
        Path dstPath = new Path(outputPath);

        ////如果原始文件存在则删除后上传
//        if (fs.exists(inputLogPath)) {
//            fs.delete(inputLogPath, true);
//        }
//        fs.copyFromLocalFile(localLogPath, inputLogPath);

        ////如果目标文件存在则删除
        if (fs.exists(dstPath)) {
            fs.delete(dstPath, true);
        }

        Job job = Job.getInstance(fs.getConf(), WordCountTest.class.getSimpleName());
        job.setJarByClass(WordCountTest.class);
        job.getConfiguration().setStrings("mapreduce.reduce.shuffle.memory.limit.percent", "0.05");

        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        FileInputFormat.setInputPaths(job, srcPath);
        FileOutputFormat.setOutputPath(job, dstPath);

        boolean b = job.waitForCompletion(true);

        fs.close();
        System.exit(b ? 0 : 1);
    }
}
