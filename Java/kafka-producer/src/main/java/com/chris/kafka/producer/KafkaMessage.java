package com.chris.kafka.producer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Create by Chris Chan
 * Create on 2019/6/18 14:59
 * Use for:
 */
public class KafkaMessage {
    private String code;
    private String msg;
    private String time;

    public KafkaMessage() {
    }

    public KafkaMessage(String code, String msg, String time) {
        this.code = code;
        this.msg = msg;
        this.time = time;
    }

    public static KafkaMessage create(String code, String msg, String time) {
        return new KafkaMessage(code, msg, time);
    }

    public static KafkaMessage create(String code, String msg, long time) {
        return new KafkaMessage(code, msg, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));
    }

    public static KafkaMessage create(String code, String msg, LocalDateTime time) {
        return new KafkaMessage(code, msg, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
