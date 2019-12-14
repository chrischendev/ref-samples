package com.aiways.storm.datapro;

import com.aiways.storm.utils.CommonUtils;
import com.chris.es.jest.utils.JestUtil;
import io.searchbox.client.JestClient;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Chris Chen
 * 2019/01/31
 * Explain:
 */

public class DataWriteUtils {
    /**
     * 写入到ES
     *
     * @param user
     */
    public void writeToEs(User user) {
        JestClient jestClient = CommonUtils.createJestClient();
        JestUtil.init(jestClient);
        try {
            JestUtil.save(user, "storm_test_name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量写入到ES
     *
     * @param userList
     */
    public void batchWriteToEs(List<User> userList) {
        JestClient jestClient = CommonUtils.createJestClient();
        JestUtil.init(jestClient);
        try {
            JestUtil.saveAll(userList, "storm_test_name");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
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
    */

    /**
     * 写入到本地文件
     *
     * @param user
     */
    public void writeToTxtFile(User user) {
        String pathname = "d:/temp_storm_file_01.txt";
        //String pathname = "/tmp/temp_storm_file_01.txt";
        try {
            FileWriter fw = new FileWriter(pathname, true);
            String contentStr = user.getName() + "\t" + user.getAge() + "\r\n";
            fw.append(contentStr);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 批量写入到本地文件
     *
     * @param userList
     */
    public void batchWriteToTxtFile(List<User> userList) {
        userList.stream().forEach(user -> writeToTxtFile(user));
    }
}
