package com.chris.netty.my.server;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 11:08
 * use for: 服务器启动器
 */
public class NioServerRunner {
    public static void main(String[] args) throws Exception {
        NioServer.create().bind(8071);
    }
}
