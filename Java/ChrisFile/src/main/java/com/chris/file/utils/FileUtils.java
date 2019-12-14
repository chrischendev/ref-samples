package com.chris.file.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * Created by Chris Chen
 * 2018/12/10
 * Explain: 文件工具
 */
@Component
public class FileUtils implements IFileUtils {

    @Override
    public String getRandomFileName(File file) {
        return getRandomFileName(file.getName());
    }

    @Override
    public String getRandomFileName(MultipartFile file) {
        return getRandomFileName(file.getOriginalFilename());
    }

    @Override
    public String getRandomFileName(String fileName) {
        String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        return getRandomFileNameByExt(ext);
    }

    @Override
    public String getRandomFileNameByExt(String fileExtName) {
        return new StringBuilder("file_")//前缀
                .append(new SimpleDateFormat("yyyyMMhhHHmmssSSS").format(System.currentTimeMillis()))//时间戳
                .append(String.format("%05d", new Random().nextInt(10000)))//五位随机数
                .append(".")
                .append(fileExtName)//原来的后缀
                .toString();
    }

    @Override
    public boolean write(MultipartFile file, String saveFileName) throws IOException {
        return write(file.getInputStream(), saveFileName);
    }

    @Override
    public boolean write(InputStream is, String saveFileName) throws IOException {
        OutputStream os = new FileOutputStream(saveFileName);
        IOUtils.copy(is, os);
        IOUtils.closeQuietly(os);
        IOUtils.closeQuietly(is);
        return true;
    }

    @Override
    public <T> T read(InputStream io, Class<T> clazz) {
        return null;
    }

    @Override
    public <T> T read(File file, Class<T> clazz) {
        return null;
    }

    @Override
    public byte[] intArrayToByteArray(int[] intArray) {

        if (intArray == null || intArray.length == 0) {
            return null;
        }
        int length = intArray.length;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) intArray[i];
        }
        return bytes;
    }
}
