package com.chris.lottery.calc;

import com.chris.lottery.calc.doublecolor.DoubleColorBallStore;
import com.chris.lottery.calc.doublecolor.DoubleColorNumber;
import com.chris.lottery.calc.doublecolor.MatchResult;
import com.chris.lottery.calc.doublecolor.PrizeResult;
import com.chris.lottery.calc.manager.SelectManager;
import com.google.gson.Gson;

import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/6/30 1:57
 * use for:
 */
public class DoubleColorTest {
    private static Gson gson = new Gson();
    private static String filePath = "D:\\dcb\\dcb-19078-20198070501.txt";//记录文件路径
    private static Integer[] prizeNumbers = {9,11, 13, 18, 21, 22, 15};//中奖号码

    public static void main(String[] args) {
        test5();
    }

    /**
     * 读取多个彩票彩票数据文件并解析
     */
    private static void test10() {
        List<DoubleColorNumber> numberList = SelectManager.readRecordSet("D:\\dcb\\dcb-20198063001.txt",
                "D:\\dcb\\dcb-20198063002.txt",
                "D:\\dcb\\dcb-20198063003.txt",
                "D:\\dcb\\dcb-20198063004.txt");
        List<DoubleColorNumber> numberList1 = SelectManager.readRecordSet("D:\\dcb\\19076");
        DoubleColorBallStore.show(numberList1);
    }

    /**
     * 测试中奖结果统计
     */
    private static void test9() {
        List<DoubleColorNumber> numberList = SelectManager.readRecordSet(filePath);
        //中奖号码
        DoubleColorNumber prizeNumber = DoubleColorNumber.build(prizeNumbers);

        List<PrizeResult> prizeResultList = DoubleColorBallStore.countPrizeResultFromNumberList(numberList, prizeNumber);
        System.out.println(gson.toJson(prizeResultList));
        System.out.println(DoubleColorBallStore.showPrizeResult(prizeResultList));
    }

    /**
     * 测试号码匹配结果分析
     * 测试中奖查询
     */
    private static void test8() {
        DoubleColorNumber number1 = DoubleColorNumber.build(1, 2, 3, 19, 20, 32, 14);
        DoubleColorNumber number2 = DoubleColorNumber.build(5, 6, 3, 17, 20, 32, 14);
        MatchResult match = DoubleColorBallStore.match(number1, number2);
        int result = DoubleColorBallStore.parseMatchResult(match);
        if (result == -1) {
            System.out.println("对不起，本次你没有中奖。");
            return;
        }
        System.out.println("恭喜，您中了 " + result + " 等奖。");
    }

    /**
     * 测试号码匹配
     */
    private static void test7() {
        DoubleColorNumber number1 = DoubleColorNumber.build(1, 2, 3, 19, 20, 32, 14);
        DoubleColorNumber number2 = DoubleColorNumber.build(5, 6, 3, 17, 20, 32, 14);
        System.out.println(gson.toJson(DoubleColorBallStore.match(number1, number2)));
    }

    /**
     * 测试读取旧数据并解析
     */
    private static void test6() {
        List<DoubleColorNumber> numberList = SelectManager.readRecordSet(filePath);
        DoubleColorBallStore.show(numberList);
    }

    /**
     * 测试选号并记录
     */
    private static void test5() {
        SelectManager.selectAndRecord(780728, 20, 10000000, filePath);
    }

    /**
     * 测试连号
     */
    private static void test4() {
        List<List<Integer>> successiveList = DoubleColorBallStore.getSuccessiveList(DoubleColorNumber.build(1, 2, 3, 19, 20, 32, 14));
        System.out.println(new Gson().toJson(successiveList));
    }

    /**
     * 测试产生一批幸运双色球
     */
    private static void test3() {
        DoubleColorBallStore.show(SelectManager.select(780624, 10, 1000000));
    }

    /**
     * 测试产生一批双色球
     */
    private static void test2() {
        DoubleColorBallStore.show(DoubleColorBallStore.buildDoubleColorNumberList(10));
    }

    /**
     * 测试产生一注双色球
     */
    private static void test1() {
        DoubleColorBallStore.show(DoubleColorBallStore.buildDoubleColorNumber());
    }
}
