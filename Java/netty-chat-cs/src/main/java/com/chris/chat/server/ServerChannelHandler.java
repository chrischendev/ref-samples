package com.chris.chat.server;

import com.chris.chat.protocol.CCRequest;
import com.chris.chat.protocol.CCResponse;
import com.chris.chat.utils.InUtils;
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
        CCResponse.sendData(ctx, "欢迎连接成功", 1);
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
        System.out.println("客户端: " + ((CCRequest) msg).getData());
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
        cause.printStackTrace();
        ctx.close();
    }

    private void send(ChannelHandlerContext ctx) {
        InUtils.inByMe(ctx, "请输入: ",0);
    }
}


