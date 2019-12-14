package com.chris.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChrisMailApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() throws IOException {
        UserModel user = new UserModel("kalychen", 34);
        StringBuilder sb = new StringBuilder();
        sb.append(user.getName()).append("\r\n")
                .append(user.getAge()).append("\r\n");
        String content = sb.toString();

        //获取项目的路径来构建
        File outFile = new File("errorfile/test-001.txt");
        //OutputStream os=new FileOutputStream(outFile);
        BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
        bw.write(content, 0, content.length());
        bw.flush();
        bw.close();

    }

}
