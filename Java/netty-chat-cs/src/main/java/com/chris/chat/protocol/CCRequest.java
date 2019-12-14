package com.chris.chat.protocol;

/**
 * 传输请求 客户端到服务器
 */

import io.netty.channel.ChannelHandlerContext;

import java.util.UUID;

public class CCRequest {

    private String id;
    private Object data;

    private CCRequest() {
    }

    public static CCRequest create() {
        return new CCRequest();
    }

    public CCRequest(String id, Object data) {
        this.id = id;
        this.data = data;
    }

    public static CCRequest create(String id, Object data) {
        return new CCRequest(id, data);
    }

    public String getId() {
        return id;
    }

    public CCRequest setId(String id) {
        this.id = id;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CCRequest setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "CCRequest{" + "id='" + id + '\'' + ", data=" + data + '}';
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
        CCRequest.create(UUID.randomUUID().toString(), msg).send(ctx);
    }

}
