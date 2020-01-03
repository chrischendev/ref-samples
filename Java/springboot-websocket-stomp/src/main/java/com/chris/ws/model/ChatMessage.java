package com.chris.ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 6:00
 * Use for: 服务器接收消息
 */
@Data@NoArgsConstructor@AllArgsConstructor
public class ChatMessage {
    private String message;
}
