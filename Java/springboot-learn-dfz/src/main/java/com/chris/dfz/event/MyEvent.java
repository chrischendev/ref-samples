package com.chris.dfz.event;

import org.springframework.context.ApplicationEvent;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 5:56
 * Use for:自定义事件
 */
public class MyEvent extends ApplicationEvent {
    private String msg;
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source,String msg) {
        super(source);
        this.msg=msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
