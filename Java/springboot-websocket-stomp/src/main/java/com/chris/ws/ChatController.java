package com.chris.ws;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 6:02
 * Use for:
 */
@RestController
public class ChatController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ask")
    @SendTo("/topic/answer")//向订阅过此主题的客户端发送消息
    public ChatResponse send(ChatMessage message) throws InterruptedException {
        System.out.println(message.getMessage());
        Thread.sleep(500);
        return new ChatResponse(message.getMessage());
    }
    @MessageMapping("/ask2")
    //@SendTo("/topic/answer2")//向订阅过此主题的客户端发送消息
    public void send2(ChatMessage message) throws InterruptedException {
        System.out.println(message.getMessage());
        Thread.sleep(500);
        simpMessagingTemplate.convertAndSend("/topic/answer2", new Gson().toJson(new ChatResponse(message.getMessage())));
    }

    //convertAndSendToUser 这个user身份如何确定？？？
}
