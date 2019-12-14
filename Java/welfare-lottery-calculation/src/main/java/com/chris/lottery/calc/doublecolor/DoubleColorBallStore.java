package com.chris.lottery.calc.doublecolor;

import com.google.gson.Gson;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * create by: Chris Chan
 * create on: 2019/6/30 1:39
 * use for: 双色球号码生成与管理
 */
public class DoubleColorBallStore {
    private static Gson gson = new Gson();

    /**
     * 产生一注双色球号码
     *
     * @return
     */
    public static DoubleColorNumber buildDoubleColorNumber() {
        DoubleColorNumber number = new DoubleColorNumber();
        //产生六个不重复红色号码
        List<Integer> redColorList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            while (true) {
                Integer redNum = new Random().nextInt(100000) % 33 + 1;
                if (redColorList.contains(redNum)) {
                    continue;
                } else {
                    redColorList.add(redNum);
                    break;
                }
            }
        }
        //对红色号码进行排序
        redColorList.sort(Integer::compareTo);
        //产生一个蓝色号码
        Integer blueNum = new Random().nextInt(100000) % 16 + 1;
        number.setRedColorList(redColorList);
        number.setBlueColor(blueNum);
        //符合要求就返回，不符合要求就再来一遍
        return matchRequire(number) ? number : buildDoubleColorNumber();
    }

    /**
     * @param number
     * @return
     */
    private static boolean matchRequire(DoubleColorNumber number) {
        //要求连号出现次数要至少一次
        return getSuccessiveList(number).size() > 0;
    }

    /**
     * 产生一批双色球号码
     *
     * @param num 注数
     * @return
     */
    public static List<DoubleColorNumber> buildDoubleColorNumberList(int num) {
        List<DoubleColorNumber> doubleColorNumberList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            doubleColorNumberList.add(buildDoubleColorNumber());
        }
        return doubleColorNumberList;
    }

    /**
     * 从一注号码中找出连号
     *
     * @param number
     * @return
     */
    public static List<List<Integer>> getSuccessiveList(DoubleColorNumber number) {
        List<List<Integer>> numList = new ArrayList<>();
        List<Integer> redColorList = number.getRedColorList();

        //遍历原始数据
        List<Integer> tmpList = null;
        for (Integer num : redColorList) {
            //遍历numList，如果在其中出现过，就跳过
            if (alreadySuccessiveWithOther(num, numList)) {
                continue;
            }
            //为其建立一个临时的分组集合
            tmpList = new ArrayList<>();
            tmpList.add(num);
            //遍历其他数据
            for (Integer num1 : redColorList) {
                //遇到自己，跳过
                if (num1 == num) {
                    continue;
                }
                //同样如果在numList出现过，也跳过
                if (alreadySuccessiveWithOther(num1, numList)) {
                    continue;
                }
                //如果有加1或者减1的关系，则添加到集合
                if (num1 + 1 == num || num1 - 1 == num) {
                    tmpList.add(num1);
                }
                //这里需要处理两个以上连号的问题
            }
            //如果只有一个元素，就说明没有找到相关的连号
            if (tmpList.size() < 2) {
                continue;
            }
            //排序
            tmpList.sort(Integer::compareTo);
            numList.add(tmpList);
        }
        return numList;
    }

    /**
     * 判断一组彩票中的一个红号事都已经跟其他号码形成了连号
     *
     * @param num
     * @param numList
     * @return
     */
    private static boolean alreadySuccessiveWithOther(Integer num, List<List<Integer>> numList) {
        for (List<Integer> nList : numList) {
            if (nList.contains(num)) {
                return true;
            }
            //检查这个数字是否与numList中某个数字已经具有连续的关系，如果有，则直接添加进去，返回true
            if (alreadySuccessiveWithOtherInNumList(num, nList)) {
                nList.add(num);
                return true;
            }

        }
        return false;
    }

    /**
     * 检查这个数字是否与nList中某个数字已经具有连续的关系，如果有，返回true
     *
     * @param num
     * @param nList
     * @return
     */
    private static boolean alreadySuccessiveWithOtherInNumList(Integer num, List<Integer> nList) {
        for (Integer n : nList) {
            if (num == n + 1 || num == n - 1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 创建记录字符串
     *
     * @param number
     * @return
     */
    public static String buildRecordString(DoubleColorNumber number) {
        List<Integer> redColorList = number.getRedColorList();
        StringBuilder sb = new StringBuilder();
        for (Integer redNum : redColorList) {
            sb.append(String.format("%02d", redNum)).append("\t");
        }
        sb.append("-\t");
        sb.append(String.format("%02d", number.getBlueColor()));
        return sb.toString();
    }

    /**
     * 解析记录字符串
     *
     * @param recordString
     * @return
     */
    public static DoubleColorNumber parseRecordString(String recordString) {
        //用tab分割,应该长度为8
        String[] split = recordString.split("\t");
        if (split.length != 8) {
            throw new RuntimeException("array lenth must is 8.");
        }
        //前六个是红号
        List<Integer> redColorList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            redColorList.add(Integer.valueOf(split[i]));
        }
        //最后一个是蓝号
        return new DoubleColorNumber(redColorList, Integer.valueOf(split[7]));
    }

    /**
     * 匹配两个号码
     * 用于查询是否中奖
     *
     * @param sourceNumber 待查号码
     * @param targetNumber 中奖号码
     */
    public static MatchResult match(DoubleColorNumber sourceNumber, DoubleColorNumber targetNumber) {
        int redMatchNum = 0;
        List<Integer> sourceNumberRedColorList = sourceNumber.getRedColorList();
        List<Integer> targetNumberRedColorList = targetNumber.getRedColorList();
        for (Integer redNum : sourceNumberRedColorList) {
            if (targetNumberRedColorList.contains(redNum)) {
                redMatchNum++;
            }
        }
        return new MatchResult(redMatchNum, sourceNumber.getBlueColor() == targetNumber.getBlueColor());
    }

    /**
     * 批量匹配号码
     *
     * @param sourceNumberList
     * @param targetNumber
     * @return
     */
    public static List<MatchResult> match(List<DoubleColorNumber> sourceNumberList, DoubleColorNumber targetNumber) {
        List<MatchResult> matchResultList = new ArrayList<>();
        for (DoubleColorNumber sourceNumber : sourceNumberList) {
            matchResultList.add(match(sourceNumber, targetNumber));
        }
        return matchResultList;
    }

    /**
     * 分析彩票匹配结果
     *
     * @param matchResult
     * @return
     */
    public static int parseMatchResult(MatchResult matchResult) {
        int matchRedNum = matchResult.getMatchRedNum();
        boolean matchBlue = matchResult.isMatchBlue();
        //1. 一等奖 6红1蓝
        if (matchRedNum == 6 && matchBlue) {
            return 1;
        }
        //2. 二等奖 6红0蓝
        if (matchRedNum == 6 && !matchBlue) {
            return 2;
        }
        //3. 三等奖 5红1蓝
        if (matchRedNum == 5 && matchBlue) {
            return 3;
        }
        //4. 四等奖 5红0蓝 或 4红1蓝
        if ((matchRedNum == 5 && !matchBlue) || (matchRedNum == 4 && matchBlue)) {
            return 4;
        }
        //5. 五等奖 4红0蓝 或 3红1蓝
        if ((matchRedNum == 4 && !matchBlue) || (matchRedNum == 3 && matchBlue)) {
            return 5;
        }
        //6. 六等奖 6红1蓝
        if (matchRedNum <= 2 && matchBlue) {
            return 6;
        }
        return -1;
    }

    /**
     * 统计中奖结果
     *
     * @param matchResultList
     * @return
     */
    public static List<PrizeResult> countPrizeResultFromMatchResultList(List<MatchResult> matchResultList) {
        List<PrizeResult> prizeResultList = new ArrayList<>();
        MultiValueMap<Integer, MatchResult> matchResultMultiValueMap = new LinkedMultiValueMap<>();
        matchResultList.stream().forEach(matchResult -> matchResultMultiValueMap.add(parseMatchResult(matchResult), matchResult));
        Set<Integer> keySet = matchResultMultiValueMap.keySet();
        for (Integer key : keySet) {
            if (key == -1) {
                continue;
            }
            prizeResultList.add(new PrizeResult(key, matchResultMultiValueMap.get(key).size()));
        }
        return prizeResultList;
    }

    /**
     * 统计一批号码的中奖结果
     *
     * @param sourceNumberList
     * @param targetNumber
     * @return
     */
    public static List<PrizeResult> countPrizeResultFromNumberList(List<DoubleColorNumber> sourceNumberList, DoubleColorNumber targetNumber) {
        List<MatchResult> matchResultList = match(sourceNumberList, targetNumber);
        List<PrizeResult> prizeResultList = countPrizeResultFromMatchResultList(matchResultList);
        return prizeResultList;
    }

    /**
     * 打印一注双色球号码
     *
     * @param number
     */
    public static void show(DoubleColorNumber number) {
        System.out.println(buildRecordString(number));
    }

    /**
     * 打印一批双色球号码
     *
     * @param numberList
     */
    public static void show(List<DoubleColorNumber> numberList) {
        for (int i = 0, len = numberList.size(); i < len; i++) {
            DoubleColorNumber number = numberList.get(i);
            show(number);
            if (i % 5 == 4) {
                System.out.println();
            }
        }
    }

    /**
     * 输出中奖结果
     *
     * @param prizeResultList
     */
    public static String showPrizeResult(List<PrizeResult> prizeResultList) {
        StringBuilder sb = new StringBuilder();
        for (PrizeResult prizeResult : prizeResultList) {
            sb.append(prizeResult.getLevel()).append(" 等奖 ").append(prizeResult.getCount()).append(" 注\n");
        }

        return sb.toString();
    }
}
