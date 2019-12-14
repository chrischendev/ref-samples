package com.aiways.storm;

import com.aiways.storm.datapro.DataWriteUtils;
import com.aiways.storm.datapro.User;

/**
 * Created by Chris Chen
 * 2019/01/31
 * Explain:
 */

public class MainTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        new DataWriteUtils().writeToTxtFile(new User("痘痘黄",2));
    }
}
