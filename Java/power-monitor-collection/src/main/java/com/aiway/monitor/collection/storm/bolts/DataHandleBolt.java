package com.aiway.monitor.collection.storm.bolts;

import com.aiway.monitor.collection.manager.TestManager;
import com.aiway.monitor.collection.model.DataPackage;
import com.aiway.monitor.collection.storm.consts.StreamIds;
import com.aiways.monitor.collection.business.utils.MonitorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.power.monitor.libs.model.Vehicle;
import com.power.monitor.libs.model.common.VehiclePloy;
import com.power.monitor.libs.model.vm.VehicleVM;
import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by Chris Chen
 * 2019/01/30
 * Explain: 将原始数据整理为VehicleList后，在此分流处理
 */

public class DataHandleBolt extends BaseRichBolt implements StreamIds {
    private OutputCollector collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        String jsonStr = tuple.getString(0);
        //解析json
        Type type = new TypeToken<List<VehicleVM>>() {
        }.getType();
        List<VehicleVM> vehicleVMList = new Gson().fromJson(jsonStr, type);

        TestManager.initTestLog(vehicleVMList);//log

        List<Vehicle> vehicleList = MonitorUtils.fromVehicleVMList(vehicleVMList);//转换
        //分离
        VehiclePloy vehiclePloy = MonitorUtils.split(vehicleList);
        List<Vehicle> vehicleNormalList = vehiclePloy.getVehicleNormalList();//普通数据
        List<Vehicle> vehicleFaultList = vehiclePloy.getVehicleFaultList();//故障数据

        DataPackage normalDataPackage = new DataPackage(vehicleNormalList);
        Values normalValues = new Values(normalDataPackage);
        DataPackage faultDataPackage = new DataPackage(vehicleFaultList);
        Values faultValues = new Values(faultDataPackage);

        //分流
        this.collector.emit(VEHICLE, normalValues);
        this.collector.emit(VEHICLE_LATEST, normalValues);
        this.collector.emit(VEHICLE_LAST_DAY, normalValues);
        this.collector.emit(BATTERY_WARNING, normalValues);
        this.collector.emit(BATTERY_ALERT, faultValues);//故障数据
        this.collector.emit(FAULT_COUNT, faultValues);//故障数据
        this.collector.emit(CHARGE_DATA, normalValues);

        //this.collector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declareStream(VEHICLE, new Fields("vehicle_list"));
        outputFieldsDeclarer.declareStream(VEHICLE_LATEST, new Fields("vehicle_list"));
        outputFieldsDeclarer.declareStream(VEHICLE_LAST_DAY, new Fields("vehicle_list"));
        outputFieldsDeclarer.declareStream(BATTERY_WARNING, new Fields("vehicle_list"));
        outputFieldsDeclarer.declareStream(BATTERY_ALERT, new Fields("vehicle_list"));
        outputFieldsDeclarer.declareStream(FAULT_COUNT, new Fields("vehicle_list"));
        outputFieldsDeclarer.declareStream(CHARGE_DATA, new Fields("vehicle_list"));
    }
}
