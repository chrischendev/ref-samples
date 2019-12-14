package com.aiway.monitor.collection.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Chris Chen
 * 2018/09/28
 * Explain:
 */

public class LoggerUtils {
    private Logger logger;

    private LoggerUtils() {
    }

    public static LoggerUtils get(Class<?> clazz) {
        LoggerUtils loggerUtils = new LoggerUtils();
        loggerUtils.logger = LoggerFactory.getLogger(clazz.getSimpleName());
        return loggerUtils;
    }

    public void d(String msg) {
        this.logger.debug(msg);
    }

    public void i(String msg) {
        this.logger.info(msg);
    }

    public void w(String msg) {
        this.logger.warn(msg);
    }

    public void e(String msg) {
        this.logger.error(msg);
    }

    public void t(String msg) {
        this.logger.trace(msg);
    }

    public void d(String tag, Object obj) {
        this.logger.debug(tag, obj);
    }

    public void d(String tag, Object... objs) {
        this.logger.debug(tag, objs);
    }

    public void prn(Object obj) {
        System.out.print(obj);
    }

    public void prnln(Object obj) {
        System.out.println(obj);
    }
}
