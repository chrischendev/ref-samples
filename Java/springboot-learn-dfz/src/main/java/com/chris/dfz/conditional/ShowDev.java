package com.chris.dfz.conditional;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 10:17
 * Use for:
 */
public class ShowDev implements IShowManager {
    @Override
    public void show() {
        System.out.println("符合条件: 开发环境");
    }
}
