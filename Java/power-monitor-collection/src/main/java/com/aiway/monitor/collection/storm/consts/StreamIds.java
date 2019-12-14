package com.aiway.monitor.collection.storm.consts;

/**
 * Created by Chris Chen
 * 2019/02/20
 * Explain: 流名称
 */

public interface StreamIds {
    String VEHICLE = "vehicle";
    String VEHICLE_LATEST = "vehicle_latest";
    String VEHICLE_LAST_DAY = "vehicle_last_day";
    String BATTERY_WARNING = "battery_warning";
    String BATTERY_ALERT = "battery_alert";
    String FAULT_COUNT = "fault_count";
    String CHARGE_DATA = "charge_data";
}
