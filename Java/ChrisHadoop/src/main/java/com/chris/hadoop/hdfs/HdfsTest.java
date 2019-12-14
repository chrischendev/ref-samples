package com.chris.hadoop.hdfs;

import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;
import org.apache.log4j.BasicConfigurator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chris Chen
 * 2018/12/11
 * Explain:
 */

public class HdfsTest {
    public static void main(String[] args) throws IOException {
        System.setProperty("hadoop.home.dir", "D:\\softs\\hadoop-2.8.5");//HADOOP_HOME
        BasicConfigurator.configure();//自动快速地使用缺省Log4j环境

        //todo
        test1();
    }

    private static void test1() throws IOException {
        FileSystem fs = HdfsUtils.getFileSystem();

        String localHostPath = "I:";
        String hdfsPath = "/chrisfolder";
        String localHostSavePath = "I:/HDFS下载文件/";

        String localHostFileName = "/spark_in_test_01.txt";
        String hdfsFileName = localHostFileName;

        //1. 上传文件
        //fs.copyFromLocalFile(new Path(localHostPath + localHostFileName), new Path(hdfsPath + hdfsFileName));

        //2. 下载文件 路径相反 文件夹自动创建
        //fs.copyToLocalFile(new Path(hdfsPath + hdfsFileName), new Path(localHostSavePath + hdfsFileName));

        //3. 删除文件
        //fs.delete(new Path("/微信截图_20181126163100.png"), true);

        //4. 创建文件夹
        //fs.mkdirs(new Path("/chrisfolder/chris_sub_folder_storm"));

        //5. 删除文件夹
        //fs.delete(new Path("/chrisfolder2"),true);

        //6. 重命名文件夹
        //rename(fs);

        //7. 遍历文件(不包括文件夹，但可以递归)
        readFileList(fs);

        //8. 遍历文件(包括文件夹，不可以递归)
        //readFileStatusList(fs);

        //9. 给文件追加内容（猜想区块链需要）
        //testAppend(fs);

        fs.close();
    }

    private static void rename(FileSystem fs) throws IOException {
        Path path1 = new Path("/chrisfolder");
        Path path2 = new Path("/chrisfdr");
        fs.mkdirs(path2);
        fs.rename(path1, path2);
    }

    private static void readFileList(FileSystem fs) throws IOException {
        Path path = new Path("/chrisfolder");
        RemoteIterator<LocatedFileStatus> fileItr = fs.listFiles(path, true);
        while (fileItr.hasNext()) {
            LocatedFileStatus fileStatus = fileItr.next();
            System.out.println("文件： " + fileStatus.getPath().toUri().getPath());
        }
    }

    private static void readFileStatusList(FileSystem fs) throws IOException {
        Path path = new Path("/chrisfolder");
        FileStatus[] fileStatuses = fs.listStatus(path);
        for (FileStatus fileStatus : fileStatuses) {
            if (fileStatus.isFile()) {
                System.out.println("文件： " + fileStatus.getPath().toUri());
            } else if (fileStatus.isDirectory()) {
                System.out.println("文件夹： " + fileStatus.getPath().toUri());
            } else {
                System.out.println("随便啦！");
            }
        }
    }

    //给txt文件追加内容
    private static void testAppend(FileSystem fs) throws IOException {
        Path path = new Path("/chrisfolder");
        String txtFile = path + "/myInfo.txt";
        String content1 = "东方红,太阳升,";
        String content2 = "中国出了个毛泽东。";

        appendToTxtFile(fs, txtFile, content1);
        appendToTxtFile(fs, txtFile, content2);

        //读取检查
        readTxtFileContent(fs, txtFile);
    }

    //追加内容到txt文件
    private static void appendToTxtFile(FileSystem fs, String filePath, String content) throws IOException {
        Path path = new Path(filePath);
        //不存在先创建
        if (!fs.exists(path)) {
            fs.create(path);
        }
        //追加内容
        //FSDataOutputStream os = fs.open(path);//改写
        FSDataOutputStream os = fs.append(path);//追加
        InputStream is = new ByteArrayInputStream(content.getBytes());
        IOUtils.copyBytes(is, os, 1024 * 4, true);
        //关闭流
        os.close();
        is.close();
    }

    //读取txt文件内容
    private static String readTxtFileContent(FileSystem fs, String filePath) throws IOException {
        Path path = new Path(filePath);
        FSDataInputStream is = fs.open(path);
        FileStatus fileStatus = fs.getFileStatus(path);
        long len = fileStatus.getLen();

        byte[] buffer = new byte[Integer.parseInt(String.valueOf(len))];
        is.readFully(0, buffer);
        is.close();
        String content = new String(buffer);
        System.out.println(content);
        return content;
    }


}
