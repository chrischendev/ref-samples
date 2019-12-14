package com.rabbitmq.producer.model;

/**
 * create by: Chris Chan
 * create on: 2019/6/16 10:08
 * use for:
 */

public class LoggerInfo {
    private String code;
    private String message;

    public LoggerInfo() {
    }

    public LoggerInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
