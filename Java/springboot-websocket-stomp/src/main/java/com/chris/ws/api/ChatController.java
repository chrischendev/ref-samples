package com.chris.ws.api;

import com.chris.ws.model.ChatMessage;
import com.chris.ws.model.ChatResponse;
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

    /**
     * 接收调用/ask发送的消息，并且转发给订阅了/topic/answer 的所有客户端
     *
     * @param message
     * @return
     * @throws InterruptedException
     */
    @MessageMapping("/ask")
    @SendTo("/topic/answer")//向订阅过此主题的客户端发送消息
    public ChatResponse send(ChatMessage message) throws InterruptedException {
        Thread.sleep(500);
        return new ChatResponse(message.getMessage());
    }

    /**
     * 接收调用/ask2发送过来的消息，并且转发给订阅了指定的topic的客户端
     *
     * @param message
     * @throws InterruptedException
     */
    @MessageMapping("/ask2")
    public void send2(ChatMessage message) throws InterruptedException {
        Thread.sleep(500);
        simpMessagingTemplate.convertAndSend("/topic/answer2", new Gson().toJson(new ChatResponse(message.getMessage())));
    }

    /**
     * 接收调用/ask3发送过来的消息，并且将消息转发给登陆过的订阅过指定topic的指定用户
     * 由于这里的用户信息在session中存放，因此一个浏览器只能标志一个用户
     *
     * @param message
     * @throws InterruptedException
     */
    @MessageMapping("/ask3")
    public void sendToUser(ChatMessage message) throws InterruptedException {
        Thread.sleep(500);
        simpMessagingTemplate.convertAndSendToUser("chris", "/topic/answer3", new Gson().toJson(new ChatResponse(message.getMessage())));
    }
}
