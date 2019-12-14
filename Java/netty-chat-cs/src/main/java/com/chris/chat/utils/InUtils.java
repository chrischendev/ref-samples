package com.chris.chat.utils;

import com.chris.chat.protocol.CCRequest;
import com.chris.chat.protocol.CCResponse;
import io.netty.channel.ChannelHandlerContext;

import java.util.Scanner;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 12:47
 * use for: 控制台键盘输入工具
 */
public class InUtils {
    public static String input(CharSequence prompt) {
        System.out.println(prompt);
        return new Scanner(System.in).next();
    }

    /**
     * 这个防范封装用于服务端和客户端在一起测试
     *
     * @param ctx
     * @param prompt
     * @param type   0 服务端发送响应 other 客户端发送请求
     */
    public static void inByMe(ChannelHandlerContext ctx, CharSequence prompt, int type) {
        String input = input(prompt);
        if (type == 0) {
            CCResponse.sendData(ctx, input);
        } else {
            CCRequest.sendData(ctx, input);
        }
        System.out.println("我：" + input);
    }
}
