package com.chris.data.config;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author chrischan
 * create on 2019\7\18 0018 16:04
 * use for:
 */
@Component
@Lazy(false)
public class DataSourceContextHolder {
    public static final String SELECT_DB = "selectDataSource";
    public static final String UPDATE_DB = "updateDataSource";

    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static void setDbType(String dbType) {
        contextHolder.set(dbType);
    }

    public static String getDbType() {
        return contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
