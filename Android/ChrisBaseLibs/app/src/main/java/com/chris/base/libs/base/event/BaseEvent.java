package com.chris.base.libs.base.event;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.base.event
 * Created by Chris Chen on 2017/7/3 16:55.
 * Explain:通信数据封装基类
 */

public class BaseEvent<Model> {
    public static final int EVENT_SUCCESS=0x00000001;
    public static final int EVENT_ERROR=0x00000002;

    public int code=EVENT_SUCCESS;//消息状态码
    public String msg;//提示信息
    public Model data;//封装的传递数据
}
