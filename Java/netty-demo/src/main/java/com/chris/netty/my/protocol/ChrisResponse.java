package com.chris.netty.my.protocol;
/**
 * 传输响应对象
 */

import io.netty.channel.ChannelHandlerContext;

import java.util.UUID;

public class ChrisResponse {

    private String id;
    private Object data;
    // 0=success -1=fail
    private int status;

    private ChrisResponse() {
    }

    public static ChrisResponse create() {
        return new ChrisResponse();
    }

    private ChrisResponse(String id, Object data, int status) {
        this.id = id;
        this.data = data;
        this.status = status;
    }

    public static ChrisResponse create(String id, Object data, int status) {
        return new ChrisResponse(id, data, status);
    }

    public String getId() {
        return id;
    }

    public ChrisResponse setId(String id) {
        this.id = id;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ChrisResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ChrisResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "ChrisResponse{" + "id='" + id + '\'' + ", data=" + data + ", status=" + status + '}';
    }

    /**
     * 发送数据
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

}
