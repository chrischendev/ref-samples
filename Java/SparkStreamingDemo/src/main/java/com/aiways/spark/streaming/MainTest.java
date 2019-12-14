package com.aiways.spark.streaming;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import org.apache.hadoop.io.Text;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.*;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaPairReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka.KafkaUtils;
import scala.Tuple2;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

/**
 * Created by Chris Chen
 * 2019/02/20
 * Explain:
 */

public class MainTest implements CommonConsts {
    //static final String ZK_QUORUM = "10.100.81.177:2181,10.100.81.178:2181,10.100.81.179:2181";
    static final String ZK_QUORUM = "192.168.0.114:49181";
    static final String GROUP = "test-consumer-group";
    static final String TOPICSS = "user_trace";
    static final String NUM_THREAD = "64";

    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir","E:\\Servers\\hadoop-2.8.5");
        testSparkWordCount();
    }

    private static void testSparkWordCount() {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("NetworkWordCount");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        //String filepath="/chrisfolder/spark_in_test_01.txt";
        String filepath = "i://chris_log_src_01.txt";

        //JavaRDD<String> stringJavaRDD = javaSparkContext.textFile(filepath);

        //读取文件失败 用list测试
        List<String> stringList = new ArrayList<>();
        stringList.add("黄昏\t汽车\t礼貌\t服装\t母婴");
        stringList.add("可爱\t美女\t自己\t司机\t汽车\t大熊猫\t书架\t暑假");
        JavaRDD<String> stringJavaRDD = javaSparkContext.parallelize(stringList);

        JavaRDD<String> wordJavaRDD = stringJavaRDD.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String s) throws Exception {
                String line = s;
                System.out.println(s);
                if (line == null) line = "";
                String[] arr = line.split("\t");
                return Arrays.asList(arr).iterator();
            }
        });

        JavaPairRDD<String, Integer> wordCountJavaRDD = wordJavaRDD.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<>(s, 1);
            }
        });

        JavaPairRDD<String, Integer> resultJavaPairRDD = wordCountJavaRDD.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1 + v2;
            }
        });
        Map<String, Integer> stringIntegerMap = resultJavaPairRDD.collectAsMap();
        System.out.println(new Gson().toJson(stringIntegerMap));
        resultJavaPairRDD.saveAsTextFile("F:/spark_result/4");
    }

    private static void test2() {
        SparkSession sparkSession = SparkSession.builder().master("local[*]").appName("NetworkWordCount").getOrCreate();
        //String filepath="/chrisfolder/spark_in_test_01.txt";
        String filepath = "F:/chris_log_src.txt";

        Dataset<String> stringDataset = sparkSession.read().textFile(filepath);
        System.out.println("执行到此~~~~~~~~~~~~~");
    }

    private static void test3() {
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCountTest");
        JavaSparkContext sc = new JavaSparkContext(conf);
        String outputDir = "i:/";

        List<String> list = new ArrayList<String>();
        list.add("1 1 2 a b");
        list.add("a b 1 2 3");
        JavaRDD<String> RddList = sc.parallelize(list);

        //先切分为单词，扁平化处理
        JavaRDD<String> flatMapRdd = RddList.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterator<String> call(String str) {
                return Arrays.asList(str.split(" ")).iterator();
            }
        });

        //再转化为键值对
        JavaPairRDD<String, Integer> pairRdd = flatMapRdd.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String word) throws Exception {
                return new Tuple2<String, Integer>(word, 1);
            }
        });

        //对每个词语进行计数
        JavaPairRDD<String, Integer> countRdd = pairRdd.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer i1, Integer i2) {
                return i1 + i2;
            }
        });
        System.out.println("结果：" + countRdd.collect());
        countRdd.saveAsTextFile(outputDir);
        sc.close();
    }
/*
    public static void testSparkStreaming() {
        SparkConf sparkConf = new SparkConf().setAppName("main.java.computingCenter");
        // Create the context with 2 seconds batch size
        //每两秒读取一次kafka
        JavaStreamingContext jssc = new JavaStreamingContext(sparkConf, new Duration(2000));

        int numThreads = Integer.parseInt(NUM_THREAD);
        Map<String, Integer> topicMap = new HashMap<String, Integer>();
        String[] topics = TOPICSS.split(",");
        for (String topic : topics) {
            topicMap.put(topic, numThreads);
        }

        JavaPairReceiverInputDStream<String, String> messages =
                KafkaUtils.createStream(jssc, ZK_QUORUM, GROUP, topicMap);


        JavaDStream<String> lines = messages.map(new Function<Tuple2<String, String>, String>() {
            public String call(Tuple2<String, String> tuple2) {
                return tuple2._2();
            }
        });

        JavaDStream<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            public Iterator<String> call(String lines) {
                //kafka数据格式："{\"Topic\":\"user_trace\",\"PartitionKey\":\"0\",\"TimeStamp\":1471524044018,\"Data\":\"0=163670589171371918%3A196846178238302087\",\"LogId\":\"0\",\"ContentType\":\"application/x-www-form-urlencoded\"}";
                List<String> arr = new ArrayList<String>();
                for (String s : lines.split(" ")) {
                    Map j = JSON.parseObject(s);
                    String s1 = "";
                    String s2 = "";
                    try {
                        s1 = URLDecoder.decode(j.get("Data").toString(), "UTF-8");
                        s2 = s1.split("=")[1];
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    arr.add(s2);
                }
                return arr.iterator();
            }
        });

        JavaPairDStream<String, String> goodsSimilarityLists = words.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {
                //过滤非法的数据
                if (s.split(":").length == 2) {
                    return true;
                }
                return false;
            }
        }).mapPartitionsToPair(new PairFlatMapFunction<Iterator<String>, String, String>() {
            //此处分partition对每个pair进行处理
            @Override
            public Iterator<Tuple2<String, String>> call(Iterator<String> s) throws Exception {
                ArrayList<Tuple2<String, String>> result = new ArrayList<Tuple2<String, String>>();
                while (s.hasNext()) {
                    String x = s.next();
                    String userId = x.split(":")[0];
                    String goodsId = x.split(":")[1];
                    System.out.println(x);
                    LinkedHashMap<Long, Double> recommendMap = null;
                    try {
                        //此service从redis读数据,进行实时兴趣度计算,推荐结果写入redis,供api层使用
                        CalculateInterestService calculateInterestService = new CalculateInterestService();
                        try {
                            recommendMap = calculateInterestService.calculateInterest(userId, goodsId);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        String text = "";
                        int count = 0;
                        for (Map.Entry<Long, Double> entry : recommendMap.entrySet()) {
                            text = text + entry.getKey();
                            if (count == recommendMap.size() - 1) {
                                break;
                            }
                            count = count + 1;
                            text = text + "{/c}";
                        }

                        text = System.currentTimeMillis() + ":" + text;
                        result.add(new Tuple2<String, String>(userId, text));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                return result;
            }
        });

        goodsSimilarityLists.foreachRDD(new Function<JavaPairRDD<String, String>, Void>() {
            @Override
            public Void call(JavaPairRDD<String, String> rdd) throws Exception {
                //打印rdd，调试方便
                System.out.println(rdd.collect());
            }
        });

        JavaPairDStream<Text, Text> goodsSimilarityListsText = goodsSimilarityLists.mapToPair(new PairFunction<Tuple2<String, String>, Text, Text>() {
            @Override
            public Tuple2<Text, Text> call(Tuple2<String, String> ori) throws Exception {
                //此处要将tuple2转化为org.apache.hadoop.io.Text格式，使用saveAsHadoopFiles方法写入hdfs
                return new Tuple2(new Text(ori._1), new Text(ori._2));
            }
        });

        //写入hdfs
        goodsSimilarityListsText.saveAsHadoopFiles("/user/hadoop/recommend_list/rl", "123", Text.class, Text.class, SequenceFileOutputFormat.class);

        jssc.start();
        jssc.awaitTermination();

    }
*/

}
