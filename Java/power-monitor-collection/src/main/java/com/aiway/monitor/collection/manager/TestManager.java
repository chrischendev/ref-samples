package com.aiway.monitor.collection.manager;

import com.power.monitor.libs.model.vm.VehicleVM;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Chris Chen
 * 2019/02/20
 * Explain:
 */

public class TestManager {
    private static long startTime;//一批次开始的时间
    private static long endTime;//结束时间
    private static int bizCount;//分流业务总数
    private static StringBuilder logInfo;//日志信息
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public static long getStartTime() {
        return startTime;
    }

    public static void setStartTime(long startTime) {
        TestManager.startTime = startTime;
    }

    public static long getEndTime() {
        return endTime;
    }

    public static void setEndTime(long endTime) {
        TestManager.endTime = endTime;
    }

    public static int getBizCount() {
        return bizCount;
    }

    public static void setBizCount(int bizCount) {
        TestManager.bizCount = bizCount;
    }

    public static StringBuilder getLogInfo() {
        return logInfo;
    }

    public static void setLogInfo(StringBuilder logInfo) {
        TestManager.logInfo = logInfo;
    }

    public static void addLogInfo(String info) {
        if (TestManager.logInfo == null) {
            TestManager.logInfo = new StringBuilder();
        }
        TestManager.logInfo.append(info).append("\r\n");
    }

    public static int bizCountAdd() {
        TestManager.bizCount++;
        return TestManager.bizCount;
    }

    public static void showLogInfo() {
        System.out.println(TestManager.logInfo);
    }

    public static void initTestLog(List<VehicleVM> vehicleVMList) {
        TestManager.logInfo=new StringBuilder();//重置
        long startTime = System.currentTimeMillis();
        TestManager.setStartTime(startTime);
        TestManager.setBizCount(0);
        TestManager.addLogInfo("==========================================================");
        TestManager.addLogInfo("本批次处理开始时间: " + sdf.format(startTime));
        TestManager.addLogInfo("本次接收到的数据一共: " + vehicleVMList.size() + " 条\n");
        //TestManager.addLogInfo("\n");
    }

    public static void showLatestLog() {
        if (TestManager.bizCountAdd() == 7) {
            long endTime = System.currentTimeMillis();
            //TestManager.addLogInfo("\n");
            TestManager.addLogInfo("\n本批次处理结束时间: " + sdf.format(endTime));
            TestManager.addLogInfo("本批次处理总耗时: " + (endTime - TestManager.getStartTime()) + " ms");
            TestManager.addLogInfo("==========================================================\n");
            TestManager.showLogInfo();
        }
    }
}
