package com.chris.chat.client;

import com.chris.chat.codec.DataDecoder;
import com.chris.chat.codec.DataEncoder;
import com.chris.chat.protocol.CCRequest;
import com.chris.chat.protocol.CCResponse;
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
public class ChatClient {
    private String host;
    private int port;
    private Channel channel;

    public static ChatClient create(String host, int port) {
        return new ChatClient(host, port);
    }

    private ChatClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Channel getChannel() {
        return channel;
    }

    public ChatClient start() throws Exception {
        if (this.host == null || this.host == "" || this.port == 0) {
            throw new RuntimeException("Host or port exception.");
        }
        final NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new DataEncoder(CCRequest.class));
                        pipeline.addLast(new DataDecoder(CCResponse.class));
                        pipeline.addLast(new ClientChannelHandler());
                    }
                });

        //连接服务器
        ChannelFuture channelFuture = bootstrap.connect(host, port);
        //添加监听器
        channelFuture.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture future) throws Exception {
                if (future.isSuccess()) {
                    System.out.println("Server connected.");
                } else {
                    System.out.println("Server connect fail.");
                    future.cause().printStackTrace();
                    eventLoopGroup.shutdownGracefully();
                }
            }
        });

        this.channel = channelFuture.channel();
        return this;
    }
}
