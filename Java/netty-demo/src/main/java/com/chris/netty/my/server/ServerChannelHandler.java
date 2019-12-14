package com.chris.netty.my.server;

import com.chris.netty.my.protocol.ChrisRequest;
import com.chris.netty.my.protocol.ChrisResponse;
import com.chris.netty.my.utils.ScannerUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 1:38
 * use for:
 */
public class ServerChannelHandler extends ChannelInboundHandlerAdapter {

    /**
     * 客户端和服务器连接成功
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("有新的客户端连接");
        ChrisResponse.sendData(ctx, "欢迎连接成功", 1);
    }

    /**
     * 读取管道数据
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("客户端: " + ((ChrisRequest) msg).getData());
        send(ctx);
    }

    /**
     * 一批数据读取结束
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //System.out.println("channelReadComplete");
        ctx.flush();
    }

    /**
     * 异常
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //System.out.println("exceptionCaught");
        cause.printStackTrace();
        ctx.close();
    }

    private void send(ChannelHandlerContext ctx) {
        String input = ScannerUtils.input("请输入: ");
        ChrisResponse.sendData(ctx, input, 1);
        System.out.println("我：" + input);
    }
}


