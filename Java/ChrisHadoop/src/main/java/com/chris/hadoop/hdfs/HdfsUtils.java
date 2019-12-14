package com.chris.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;

/**
 * Created by Chris Chen
 * 2018/12/14
 * Explain:
 */

public class HdfsUtils {
    /**
     * 创建FileSystem
     *
     * @return
     * @throws IOException
     */
    public static FileSystem getFileSystem() throws IOException {
        Configuration conf = new Configuration();
        String URL = "hdfs://10.100.81.175";
        //FileSystem fileSystem = FileSystem.get(URI.create(URL), conf);

        conf.set("fs.defaultFS", URL);
        FileSystem fileSystem = FileSystem.get(conf);

        return fileSystem;
    }
}
