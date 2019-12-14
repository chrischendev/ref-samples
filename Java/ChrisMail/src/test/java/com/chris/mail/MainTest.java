package com.chris.mail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        test1();
    }

    private static void test1() throws IOException {
        UserModel user = new UserModel("kalychen", 34);
        StringBuilder sb = new StringBuilder();
        sb.append(user.getName()).append("\r\n")
                .append(user.getAge()).append("\r\n");
        String content = sb.toString();

        File outFile = new File("classpath:/errorfile/test-001.txt");
        //OutputStream os=new FileOutputStream(outFile);
        BufferedWriter bw = new BufferedWriter(new FileWriter(outFile));
        bw.write(content, 0, content.length());
        bw.flush();
        bw.close();

    }
}
