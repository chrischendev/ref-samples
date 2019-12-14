package com.chris.netty.my.server;

import com.chris.netty.my.codec.ChrisDecoder;
import com.chris.netty.my.codec.ChrisEncoder;
import com.chris.netty.my.protocol.ChrisRequest;
import com.chris.netty.my.protocol.ChrisResponse;
import com.chris.netty.reference.RpcDecoder;
import com.chris.netty.reference.RpcEncoder;
import com.chris.netty.reference.RpcRequest;
import com.chris.netty.reference.RpcResponse;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 1:28
 * use for:
 * 资料 https://blog.csdn.net/qq_22200097/article/details/83042424
 */
public class NioServer {

    private NioServer() {
    }

    public static NioServer create() {
        return new NioServer();
    }

    public void bind(int port) throws Exception {
        if (port == 0) {
            throw new RuntimeException("port exception.");
        }

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(); //主IO事件线程组
        NioEventLoopGroup workGroup = new NioEventLoopGroup(); //工作channel事件线程组

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128) //制定队列大小
                .childOption(ChannelOption.SO_KEEPALIVE, true) //保持长连接
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel ch) throws Exception {
                        /*
                        在Netty里，Channel是通讯的载体，而ChannelHandler负责Channel中的逻辑处理。
                        它是Netty网络通信的主体，由它负责同对端进行网络通信、注册和数据操作等功能。
                        状态主要包括：打开、关闭、连接
                        主要的IO操作，读(read)、写(write)、连接(connect)、绑定(bind)。
                        所有的IO操作都是异步的，调用诸如read,write方法后，并不保证IO操作完成，但会返回一个凭证，在IO操作成功，取消或失败后会记录在该凭证中。

                        ChannelPipeline可以理解为ChannelHandler的容器：
                        一个Channel包含一个ChannelPipeline，所有ChannelHandler都会注册到ChannelPipeline中，并按顺序组织起来。
                        channel事件消息在ChannelPipeline中流动和传播，相应的事件能够被ChannelHandler拦截处理、传递、忽略或者终止。
                         */
                        ChannelPipeline channelPipeline = ch.pipeline();
                        channelPipeline.addLast(new ChrisEncoder(ChrisResponse.class)); //对相应数据进行编码
                        channelPipeline.addLast(new ChrisDecoder(ChrisRequest.class)); //对请求数据进行解码
                        channelPipeline.addLast(new ServerChannelHandler());
                    }
                });
        ChannelFuture channelFuture = serverBootstrap.bind(8071).sync();

        if (channelFuture.isSuccess()) {
            System.out.println("服务器启动成功");
        } else {
            System.out.println("服务器启动失败");
            channelFuture.cause().printStackTrace();
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

        channelFuture.channel().closeFuture().sync();//端口绑定成功之后，增加一个管道关闭的监听
    }
}
