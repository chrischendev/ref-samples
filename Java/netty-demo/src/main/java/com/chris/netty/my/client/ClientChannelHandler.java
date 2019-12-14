package com.chris.netty.my.client;

import com.chris.netty.my.protocol.ChrisRequest;
import com.chris.netty.my.protocol.ChrisResponse;
import com.chris.netty.my.utils.ScannerUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 1:39
 * use for:
 */
public class ClientChannelHandler extends SimpleChannelInboundHandler<ChrisResponse> {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("已成功连接到服务器.");
    }

    /**
     * 读取管道数据
     *
     * @param ctx
     * @param response
     * @throws Exception
     */
    protected void channelRead0(ChannelHandlerContext ctx, ChrisResponse response) throws Exception {
        System.out.println("服务器: " + response.getData());
        send(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //System.out.println("exceptionCaught");
        cause.printStackTrace();
        ctx.close();
    }

    private void send(ChannelHandlerContext ctx) {
        String input = ScannerUtils.input("请输入: ");
        ChrisRequest.sendData(ctx, input);
        System.out.println("我：" + input);
    }
}
