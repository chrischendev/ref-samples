package com.aiways.storm;

import com.aiways.storm.datapro.DataWriteUtils;
import com.aiways.storm.datapro.User;

public class MainTest {

    public static void main(String[] args) {
        new DataWriteUtils().writeToMySql(new User("陈凯利", 39));
    }

}

