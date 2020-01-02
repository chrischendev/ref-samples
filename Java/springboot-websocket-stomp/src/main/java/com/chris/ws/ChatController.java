package com.chris.ws;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 6:02
 * Use for:
 */
@RestController
@RequestMapping("/ws")
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/answer")
    public ChatResponse send(ChatMessage message) throws InterruptedException {
        System.out.println(message.getMessage());
        Thread.sleep(3000);
        return new ChatResponse("Welcome," + message.getMessage());
    }
}
