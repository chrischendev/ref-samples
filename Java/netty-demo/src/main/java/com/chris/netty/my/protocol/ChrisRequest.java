package com.chris.netty.my.protocol;

/**
 * 传输请求对象
 */

import io.netty.channel.ChannelHandlerContext;

import java.util.UUID;

public class ChrisRequest {

    private String id;
    private Object data;

    private ChrisRequest() {
    }

    public static ChrisRequest create() {
        return new ChrisRequest();
    }

    public ChrisRequest(String id, Object data) {
        this.id = id;
        this.data = data;
    }

    public static ChrisRequest create(String id, Object data) {
        return new ChrisRequest(id, data);
    }

    public String getId() {
        return id;
    }

    public ChrisRequest setId(String id) {
        this.id = id;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ChrisRequest setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ChrisRequest{" + "id='" + id + '\'' + ", data=" + data + '}';
    }

    /**
     * 发送数据
     *
     * @param ctx
     */
    public void send(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(this);
    }

    /**
     * 向服务器发送请求
     *
     * @param ctx
     * @param msg
     */
    public static void sendData(ChannelHandlerContext ctx, String msg) {
        ChrisRequest.create(UUID.randomUUID().toString(), msg).send(ctx);
    }

}
