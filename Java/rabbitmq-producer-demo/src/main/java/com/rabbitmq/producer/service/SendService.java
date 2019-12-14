package com.rabbitmq.producer.service;

import com.rabbitmq.producer.model.LoggerInfo;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Chris Chen
 * 2018/12/29
 * Explain:
 */
@Service
public class SendService {
    @Autowired
    RabbitTemplate rabbitTemplate;
    private static final String LOGGER_INFO_QUEUE="LOGGER_INFO_QUEUE";

    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean b, String s) {
                String correlationDataId = correlationData == null ? "无ID" : correlationData.getId();
                if (b) {
                    System.out.println("消息发送成功: " + correlationDataId);
                } else {
                    System.out.println("消息发送失败: " + correlationDataId);
                    //发送失败 再发
                    if (LoggerInfo.class.getName().equals(correlationDataId)) {
                        sendData();
                        return;
                    }

                }
            }
        });
    }

    //发送普通文本消息
    public void send(String message) {
        rabbitTemplate.convertAndSend(LOGGER_INFO_QUEUE, message);
    }

    //发送车辆信息数据
    public void sendData() {
        LoggerInfo loggerInfo=new LoggerInfo("0","success.");

        rabbitTemplate.convertAndSend(LOGGER_INFO_QUEUE, loggerInfo, new CorrelationData(LoggerInfo.class.getName()));//发送到MQ
    }
}
