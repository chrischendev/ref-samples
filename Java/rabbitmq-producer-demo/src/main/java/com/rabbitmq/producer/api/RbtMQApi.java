package com.rabbitmq.producer.api;

import com.rabbitmq.producer.model.LoggerInfo;
import com.rabbitmq.producer.service.SendService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chris Chen
 * 2018/12/29
 * Explain:
 */
@RestController
public class RbtMQApi {
    @Autowired
    SendService sendService;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String send(String message) {
        sendService.send(message);
        return "发送成功！";
    }

    @PostMapping("/sendData")
    public String sendData(@RequestBody LoggerInfo loggerInfo) {
        //rabbitTemplate.convertAndSend(POWER_DASHBOARD_AGG_QUEUE, vehicleDataBlock, new CorrelationData(VehicleData.class.getName()));
        return "发送车辆信息数据成功！";
    }


}
