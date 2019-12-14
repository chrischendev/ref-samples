package com.chris.chat.server;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 11:08
 * use for: 服务器启动器
 */
public class ServerRunner {
    public static void main(String[] args) throws Exception {
        ChatServer.create().bind(8071);
    }
}
