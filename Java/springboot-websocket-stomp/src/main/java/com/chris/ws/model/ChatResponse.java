package com.chris.ws.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by Chris Chan
 * Create on 2020/1/3 6:01
 * Use for: 服务器发送消息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponse {
    private String message;
}
