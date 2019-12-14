package com.chris.myqq;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * create by: Chris Chan
 * create on: 2019/9/3 13:13
 * use for:
 */
@Component
@ServerEndpoint("/chat/{username}")
public class ChatClient {
    private static CopyOnWriteArraySet<ChatClient> clientSet = new CopyOnWriteArraySet<>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        this.session = session;
        this.username = username;
        clientSet.add(this);
        sendToAll("系统通知: " + username + " 已上线。当前在线 " + clientSet.size() + " 人");
    }

    @OnClose
    public void onClose() {
        if (clientSet.contains(this)) {
            clientSet.remove(this);
        }
        sendToAll("系统通知: " + username + " 已下线。当前在线 " + clientSet.size() + " 人");
    }

    @OnError
    public void onError(Throwable throwable) {
        if (clientSet.contains(this)) {
            clientSet.remove(this);
        }
    }

    @OnMessage
    public void onMessage(String message) {
        handMessage(message);
    }

    private void handMessage(String message) {
        String sendMsg = this.username + " 说: " + message;
        sendToAll(sendMsg);
    }

    private void sendToAll(String sendMsg) {
        System.out.println(sendMsg);
        for (ChatClient client : clientSet) {
            try {
                client.session.getBasicRemote().sendText(sendMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
