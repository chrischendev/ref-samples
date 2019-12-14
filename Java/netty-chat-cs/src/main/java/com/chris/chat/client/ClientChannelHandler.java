package com.chris.chat.client;

import com.chris.chat.protocol.CCResponse;
import com.chris.chat.utils.InUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 1:39
 * use for:
 */
public class ClientChannelHandler extends SimpleChannelInboundHandler<CCResponse> {
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
    protected void channelRead0(ChannelHandlerContext ctx, CCResponse response) throws Exception {
        System.out.println("服务器: " + response.getData());
        send(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private void send(ChannelHandlerContext ctx) {
        InUtils.inByMe(ctx, "请输入: ", 1);
    }
}
