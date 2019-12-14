package com.chris.netty.my.utils;

import java.util.Scanner;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 12:47
 * use for: 控制台键盘输入工具
 */
public class ScannerUtils {
    public static String input(CharSequence prompt) {
        System.out.println(prompt);
        return new Scanner(System.in).next();
    }
}
