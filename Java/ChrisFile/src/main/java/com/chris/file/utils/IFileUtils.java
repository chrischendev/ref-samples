package com.chris.file.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chris Chen
 * 2018/12/10
 * Explain:
 */

public interface IFileUtils {
    String getRandomFileName(File file);

    String getRandomFileName(MultipartFile file);

    String getRandomFileName(String fileName);

    String getRandomFileNameByExt(String fileExtName);

    boolean write(MultipartFile file, String saveFileName) throws IOException;

    boolean write(InputStream io, String saveFileName) throws IOException;

    <T> T read(InputStream io, Class<T> clazz);

    <T> T read(File file, Class<T> clazz);

    byte[] intArrayToByteArray(int[] intArray);
}
