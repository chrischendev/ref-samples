package com.chris.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.Scanner;

@Sharable                                //1
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));//2 通道激活时，发送消息
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {                    //4
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("Client received from server: " + msg.toString(CharsetUtil.UTF_8));    //3 收到服务器传回来的数据，显示

        //这使我自己加的，收到服务器消息，再发送一条 有问题
//        System.out.println("请输入消息：");
//        String m= new Scanner(System.in).next();
//        ctx.writeAndFlush(Unpooled.copiedBuffer(m, CharsetUtil.UTF_8));
    }
}