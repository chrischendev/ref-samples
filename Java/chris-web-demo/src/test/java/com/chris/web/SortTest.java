package com.chris.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create by Chris Chan
 * Create on 2019/6/1 21:51
 * Use for:
 */
public class SortTest {
    private static List<Integer> numList;

    public static void main(String[] args) {
        initList();
        showList();
        System.out.println();
        System.out.println();
        System.out.println("排序...");

        test2();//排序

        System.out.println();
        System.out.println();
        System.out.println("排序后...");
        showList();
    }

    //初始化数据集合
    private static void initList() {
        numList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numList.add(new Random().nextInt(500));
        }
    }

    //初打印数据集合
    private static void showList() {
        System.out.println();
        for (int i = 0, len = numList.size(); i < len; i++) {
            System.out.print(numList.get(i) + "\t");
//            if ((i + 1) % 20 == 0) {
//                System.out.println();
//            }
        }
    }


    //冒泡排序
    private static void test1() {
        for (int len = numList.size() - 1; len > 1; len--) {
            for (int i = 0; i < len; i++) {
                Integer n1 = numList.get(i);
                Integer n2 = numList.get(i + 1);
                if (n1 > n2) {
                    numList.set(i, n2);
                    numList.set(i + 1, n1);
                }
            }
            showList();
        }
    }
    //选择排序
    private static void test2() {
        for (int i = 0,len=numList.size(); i<len-1; i++) {
            for (int j = i+1; j < len; j++) {
                Integer n1 = numList.get(i);
                Integer n2 = numList.get(j);
                if (n1 > n2) {
                    numList.set(i, n2);
                    numList.set(j, n1);
                }
            }
            showList();
        }
    }
}
