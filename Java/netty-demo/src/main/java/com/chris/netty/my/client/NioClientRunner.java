package com.chris.netty.my.client;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 11:08
 * use for: 客户端启动器
 */
public class NioClientRunner {
    public static void main(String[] args) throws Exception {
        NioClient.create("localhost", 8071).start();
    }
}
