package com.chris.netty.my.client;

import com.chris.netty.my.codec.ChrisDecoder;
import com.chris.netty.my.codec.ChrisEncoder;
import com.chris.netty.my.protocol.ChrisRequest;
import com.chris.netty.my.protocol.ChrisResponse;
import com.chris.netty.reference.RpcDecoder;
import com.chris.netty.reference.RpcEncoder;
import com.chris.netty.reference.RpcRequest;
import com.chris.netty.reference.RpcResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 2:10
 * use for:
 */
public class NioClient {
    private String host;
    private int port;
    private Channel channel;

    public static NioClient create(String host, int port) {
        return new NioClient(host, port);
    }

    private NioClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Channel getChannel() {
        return channel;
    }

    public NioClient start() throws Exception {
        if (this.host == null || this.host == "" || this.port == 0) {
            throw new RuntimeException("host or port exception.");
        }
        final NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new ChrisEncoder(ChrisRequest.class));
                        pipeline.addLast(new ChrisDecoder(ChrisResponse.class));
                        pipeline.addLast(new ClientChannelHandler());
                    }
                });

        //连接服务器
        ChannelFuture channelFuture = bootstrap.connect(host, port);
        //添加监听器
        channelFuture.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("服务器连接成功");
                } else {
                    System.out.println("服务器连接失败");
                    future.cause().printStackTrace();
                    eventLoopGroup.shutdownGracefully();
                }
            }
        });

        this.channel = channelFuture.channel();
        return this;
    }
}
