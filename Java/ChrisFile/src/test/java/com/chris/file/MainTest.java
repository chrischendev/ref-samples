package com.chris.file;

import com.chris.file.utils.FileUtils;

/**
 * Created by Chris Chen
 * 2018/12/10
 * Explain:
 */

public class MainTest {
    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        System.out.println(Byte.valueOf("-119"));
        System.out.println((byte) -119);
    }

    private static void test1() {
        FileUtils fileUtils = new FileUtils();
        String name = fileUtils.getRandomFileName("file.doc");
        System.out.println(name);
    }
}
