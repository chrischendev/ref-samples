package com.aiway.monitor.collection.proxy;

import com.aiway.monitor.collection.consts.AppCommonConsts;
import com.aiway.monitor.collection.manager.TestManager;
import com.aiways.monitor.collection.business.manager.DataHandle;
import com.aiways.monitor.collection.business.manager.IDataHandle;
import com.aiways.monitor.collection.business.utils.MonitorUtils;
import com.power.monitor.libs.model.Vehicle;
import com.power.monitor.libs.model.vm.VehicleVM;

import java.util.List;

/**
 * Created by Chris Chen
 * 2019/02/14
 * Explain: 用代理方式对各种操作进行加强处理
 * 主要目的是把支线操作放入线程
 */
public class DataHandleProxy implements AppCommonConsts, IDataHandle {
    public static final String[] ES_URLS = {
            "http://10.100.81.151:9200",//local es
            "http://10.100.81.151:9200",//dev es
            "http://10.100.81.168:9200"//test es
    };
    private DataHandle dataHandle;

    public DataHandleProxy() {
        this.dataHandle = new DataHandle(ES_URLS[ENV_INDEX], 1000 * 20);
    }

    public static DataHandleProxy get() {
        return new DataHandleProxy();
    }

    @Override
    public synchronized void addVehicleVMList(List<VehicleVM> vehicleVMList) {
        TestManager.initTestLog(vehicleVMList);
        ////检查参数
        if (vehicleVMList == null || vehicleVMList.size() == 0) {
            return;
        }
        List<Vehicle> vehicleList = MonitorUtils.fromVehicleVMList(vehicleVMList);
        ////如果没有成功整理，表示很多补充信息没有能正确匹配，原始数据有问题，不作操作
        if (vehicleList == null || vehicleList.size() == 0) {
            return;
        }
        //1. 先把数据当作历史数据写入(异步处理)
        addVehicleList(vehicleList);
        //2-1. 扩展数据 纯粹增量操作的数据，可以批量处理
        addExtIndex(vehicleList);
        //2-2. 扩展数据 具有更新功能的数据，需要逐条处理
        updateExtIndex(vehicleList);
    }

    @Override
    public synchronized void addVehicleList(List<Vehicle> vehicleList) {
        long startTime = System.currentTimeMillis();
        dataHandle.addVehicleList(vehicleList);
        TestManager.addLogInfo("addVehicleList 耗时: " + (System.currentTimeMillis() - startTime) + " ms");
        //TestManager.addLogInfo("addVehicleList 线程ID: " + Thread.currentThread().getId());
        TestManager.showLatestLog();
    }

    @Override
    public void addExtIndex(List<Vehicle> vehicleList) {
        addWaring(vehicleList);
        addAlert(vehicleList);
    }


    @Override
    public void updateExtIndex(List<Vehicle> vehicleList) {
        //1. 更新最新数据 数据库中最近一条最新数据
        processVehicleLatest(vehicleList);
        //2. 更新故障统计数据
        processFaultCountData(vehicleList);
        //3. 更新上一天最后一条数据
        processVehicleLastDay(vehicleList);
        //4. 处理充电记录数据
        processChargeData(vehicleList);
    }


    @Override
    public synchronized void processVehicleLatest(List<Vehicle> vehicleList) {
        long startTime = System.currentTimeMillis();
        dataHandle.processVehicleLatest(vehicleList);
        TestManager.addLogInfo("processVehicleLatest 耗时: " + (System.currentTimeMillis() - startTime) + " ms");
        //TestManager.addLogInfo("processVehicleLatest 线程ID: " + Thread.currentThread().getId());
        TestManager.showLatestLog();
    }


    @Override
    public synchronized void processVehicleLastDay(List<Vehicle> vehicleList) {
        long startTime = System.currentTimeMillis();
        dataHandle.processVehicleLastDay(vehicleList);
        TestManager.addLogInfo("processVehicleLastDay 耗时: " + (System.currentTimeMillis() - startTime) + " ms");
        //TestManager.addLogInfo("processVehicleLatest 线程ID: " + Thread.currentThread().getId());
        TestManager.showLatestLog();
    }


    @Override
    public synchronized void processFaultCountData(List<Vehicle> vehicleList) {
        long startTime = System.currentTimeMillis();
        dataHandle.processFaultCountData(vehicleList);
        TestManager.addLogInfo("processFaultCountData 耗时: " + (System.currentTimeMillis() - startTime) + " ms");
        //TestManager.addLogInfo("processFaultCountData 线程ID: " + Thread.currentThread().getId());
        TestManager.showLatestLog();
    }


    @Override
    public synchronized void addWaring(List<Vehicle> list) {
        long startTime = System.currentTimeMillis();
        dataHandle.addWaring(list);
        TestManager.addLogInfo("addWaring 耗时: " + (System.currentTimeMillis() - startTime) + " ms");
        //TestManager.addLogInfo("addWaring 线程ID: " + Thread.currentThread().getId());
        TestManager.showLatestLog();
    }


    @Override
    public synchronized void addAlert(List<Vehicle> list) {
        long startTime = System.currentTimeMillis();
        dataHandle.addAlert(list);
        TestManager.addLogInfo("addAlert 耗时: " + (System.currentTimeMillis() - startTime) + " ms");
        //TestManager.addLogInfo("addAlert 线程ID: " + Thread.currentThread().getId());
        TestManager.showLatestLog();
    }


    @Override
    public synchronized void processChargeData(List<Vehicle> list) {
        long startTime = System.currentTimeMillis();
        dataHandle.processChargeData(list);
        TestManager.addLogInfo("processChargeData 耗时: " + (System.currentTimeMillis() - startTime) + " ms");
        //TestManager.addLogInfo("processChargeData 线程ID: " + Thread.currentThread().getId());
        TestManager.showLatestLog();
    }


}
