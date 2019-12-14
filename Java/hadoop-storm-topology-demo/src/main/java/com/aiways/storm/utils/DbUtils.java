package com.aiways.storm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Chris Chen
 * 2019/01/31
 * Explain:
 */

public class DbUtils {
    private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static String[] DATABASE_INFO = {
            "rm-uf6cv6w6g5l7cdf7x.mysql.rds.aliyuncs.com",
            "3306",
            "sit_ems_rds",
            "ems",
            "ow1fWn7g"
    };
/*
    public static Connection getConnetion() {
        String[] databaseInfo = DATABASE_INFO;
        String DB_PARAMS = "useSSL=false";
        String DB_URL = "jdbc:mysql://" + databaseInfo[0] + ":" + databaseInfo[1] + "/" + databaseInfo[2] + "?" + DB_PARAMS;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            Connection connection = DriverManager.getConnection(DB_URL, databaseInfo[3], databaseInfo[4]);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    */
}
