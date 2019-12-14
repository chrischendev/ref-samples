package com.aiways.storm.datapro;

import java.util.List;

/**
 * Created by Chris Chen
 * 2019/02/02
 * Explain:
 */

public class MessageBody {
    private List<User> userList;

    public MessageBody() {
    }

    public MessageBody(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
