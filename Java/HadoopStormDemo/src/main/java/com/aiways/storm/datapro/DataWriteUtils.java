package com.aiways.storm.datapro;

import com.aiways.storm.utils.CommonUtils;
import com.aiways.storm.utils.DbUtils;
import com.chris.es.jest.utils.JestUtil;
import io.searchbox.client.JestClient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Chris Chen
 * 2019/01/31
 * Explain:
 */

public class DataWriteUtils {
    public void writeToEs(User user) {
        JestClient jestClient = CommonUtils.createJestClient();
        JestUtil.init(jestClient);
        try {
            JestUtil.save(user, "storm_test_name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToMySql(User user) {
        String sql = "insert into storm_test_user(name,age) value (?,?)";
        Connection conn = DbUtils.getConnetion();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1, user.getName());
            preparedStatement.setObject(2, user.getAge());
            boolean b = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
