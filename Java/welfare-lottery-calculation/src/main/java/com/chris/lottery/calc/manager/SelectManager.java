package com.chris.lottery.calc.manager;

import com.chris.lottery.calc.doublecolor.DoubleColorBallStore;
import com.chris.lottery.calc.doublecolor.DoubleColorNumber;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * create by: Chris Chan
 * create on: 2019/6/30 2:11
 * use for: 选号管理器
 */
public class SelectManager {
    private static Gson gson = new Gson();

    /**
     * 当幸运数字匹配设定值时，选中的号码组为中意的号码
     *
     * @param lucky 幸运数字 1000000以内的随机数匹配
     * @param num   需要生成的彩票总数
     * @return
     */
    public static List<DoubleColorNumber> select(int lucky, int num, int luckyRange) {
        List<DoubleColorNumber> doubleColorNumberList = new ArrayList<>();
        final int[] rndLucky = {0};
        //开启线程，产生随机数
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    rndLucky[0] = new Random().nextInt(luckyRange);
                    System.out.println(rndLucky[0]);
                    if (lucky == rndLucky[0]) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }).start();
        //主线程产生彩票，幸运数字匹配时停止
        while (lucky != rndLucky[0]) {
            doubleColorNumberList = DoubleColorBallStore.buildDoubleColorNumberList(num);
            System.out.println(gson.toJson(doubleColorNumberList));
        }
        return doubleColorNumberList;
    }

    /**
     * 选号并且记录在文本文件中
     */
    public static void selectAndRecord(int lucky, int num, int luckyRange, String filePath) {
        List<DoubleColorNumber> numberList = select(lucky, num, luckyRange);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(filePath);
            List<String> jsonList = numberList.stream().map(number -> DoubleColorBallStore.buildRecordString(number)).collect(Collectors.toList());
            System.out.println(gson.toJson(jsonList));
            //IOUtils.writeLines(jsonList, null, outputStream, Charset.defaultCharset());
            FileUtils.writeLines(new File(filePath), jsonList, true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    /**
     * 读取彩票数据并解析
     *
     * @param filePath
     * @return
     */
    public static List<DoubleColorNumber> readRecordSet(String filePath) {
        List<DoubleColorNumber> numberList = new ArrayList<>();
        File file = new File(filePath);
        //如果不是文件夹，就是文件，直接读取返回
        if (!file.isDirectory()) {
            return readRecordSet(file);
        }
        //否则就是文件夹，需要读取文件夹下面的所有文件，并进行解析
        File[] files = file.listFiles();
        Arrays.asList(files).stream().forEach(file1 -> numberList.addAll(readRecordSet(file1)));
        return numberList;
    }

    /**
     * 读取彩票数据并解析
     *
     * @param filePath
     * @return
     */
    public static List<DoubleColorNumber> readRecordSet(File filePath) {
        List<DoubleColorNumber> numberList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            List<String> jsonList = IOUtils.readLines(fileInputStream, Charset.defaultCharset());
            for (String jsonStr : jsonList) {
                numberList.add(DoubleColorBallStore.parseRecordString(jsonStr));
            }
            return numberList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(fileInputStream);
        }
        return null;
    }

    /**
     * 读取多个彩票彩票数据文件并解析
     *
     * @param filePaths
     * @return
     */
    public static List<DoubleColorNumber> readRecordSet(String... filePaths) {
        List<DoubleColorNumber> numberList = new ArrayList<>();
        for (String filePath : filePaths) {
            numberList.addAll(readRecordSet(filePath));
        }
        return numberList;
    }
}
