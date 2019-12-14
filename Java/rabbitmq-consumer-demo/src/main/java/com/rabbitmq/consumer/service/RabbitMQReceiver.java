package com.rabbitmq.consumer.service;

import com.dashboard.baselibs.consts.MQQueueNames;
import com.dashboard.baselibs.model.mq.datablock.BatteryDataBlock;
import com.dashboard.baselibs.model.mq.datablock.VehicleDataBlock;
import com.dashboard.baselibs.model.mq.datablock.VehicleRepairDataBlock;
import com.dashboard.baselibs.model.mq.datablock.VehicleSaleDataBlock;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Chris Chen
 * 2018/12/29
 * Explain: 消息接收者
 */
//@RabbitListener(queues = MQQueueNames.POWER_DASHBOARD_AGG_QUEUE)
@RabbitListener(queues = "q-name-test")
@Component
public class RabbitMQReceiver {
    @Autowired
    Gson gson;

    @RabbitHandler
    public void receive(String message) {
        System.out.println(message);
    }

    @RabbitHandler
    public void receiveVehicleDataBlock(VehicleDataBlock dataBlock) {
        System.out.println("接到车辆信息数据块：  " + gson.toJson(dataBlock));
    }

    @RabbitHandler
    public void receiveBatteryDataBlock(BatteryDataBlock dataBlock) {
        System.out.println("接到电池信息数据块：  " + gson.toJson(dataBlock));
    }

    @RabbitHandler
    public void receiveVehicleRepairDataBlock(VehicleRepairDataBlock dataBlock) {
        System.out.println("接到车辆维修信息数据块：  " + gson.toJson(dataBlock));
    }

    @RabbitHandler
    public void receiveVehicleSaleDataBlock(VehicleSaleDataBlock dataBlock) {
        System.out.println("接到车辆销售信息数据块：  " + gson.toJson(dataBlock));
    }
}
