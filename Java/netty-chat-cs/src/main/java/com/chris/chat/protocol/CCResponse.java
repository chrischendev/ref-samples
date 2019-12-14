package com.chris.chat.protocol;
/**
 * 响应对象 服务器到客户端
 */

import io.netty.channel.ChannelHandlerContext;

import java.util.UUID;

public class CCResponse {

    private String id;
    private Object data;
    private int status; // 0 成功 其他 失败 具体失败原因另外定义

    private CCResponse() {
    }

    public static CCResponse create() {
        return new CCResponse();
    }

    private CCResponse(String id, Object data, int status) {
        this.id = id;
        this.data = data;
        this.status = status;
    }

    public static CCResponse create(String id, Object data, int status) {
        return new CCResponse(id, data, status);
    }

    public String getId() {
        return id;
    }

    public CCResponse setId(String id) {
        this.id = id;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CCResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public CCResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "CCResponse{" + "id='" + id + '\'' + ", data=" + data + ", status=" + status + '}';
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
     * 发送数据
     *
     * @param ctx
     * @param msg
     * @param status
     */
    public static void sendData(ChannelHandlerContext ctx, String msg, int status) {
        create(UUID.randomUUID().toString(), msg, status).send(ctx);
    }

    public static void sendData(ChannelHandlerContext ctx, String msg) {
        create(UUID.randomUUID().toString(), msg, 0).send(ctx);
    }
}
