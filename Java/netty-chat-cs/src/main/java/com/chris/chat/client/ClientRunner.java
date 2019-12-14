package com.chris.chat.client;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 11:08
 * use for: 客户端启动器
 */
public class ClientRunner {
    public static void main(String[] args) throws Exception {
        ChatClient.create("localhost", 8071).start();
    }
}
