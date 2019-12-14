package com.chris.javacv.newcodec;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.UUID;
import java.util.Vector;

//测试成功
public class MergeFileTest {
    private static final String[] FILE_PATHS = {"D:/name.txt", "D:/ysh.jpg", "N:/梦想院线/老电影/二子开店.mp4"};
    private static final String[] SPLIT_FILE_EXT = {"txt", "jpg", "mp4"};//目前规定第三个是mp4视频文件
    private static final String MERGE_FILE_PATHS = "D:/merge-1.cov";
    private static final String SPLIT_FILE_TEMP_PATHS = "D:/covtemp/";

    public static void main(String[] args) throws IOException {
        merge(FILE_PATHS, MERGE_FILE_PATHS);
//        split(MERGE_FILE_PATHS);
    }

    //把先前合并好的文件分隔开来
    public static String[] split(String covFIlePath) throws IOException {
        String[] split_file_names = new String[3];//分开后的三合临时文件
        //尝试读取前26个字节
        FileInputStream fis = new FileInputStream(new File(covFIlePath));
        byte[] headTypeArray = new byte[26];
        fis.read(headTypeArray);//读取到数组中 此时指针在第一个文件头部
        //先把头部还原看看
        //System.out.println(Arrays.toString(headTypeArray));
        CovTypeHead covTypeHead = CovTypeHead.get(headTypeArray);
        byte[] typeHeadArray = covTypeHead.toByteArray();
        //System.out.println(Arrays.toString(typeHeadArray));
        //读取内部文件 按顺序读取
        for (int i = 0, len = covTypeHead.fileLens.length; i < len; i++) {
            String filePath = new StringBuffer(SPLIT_FILE_TEMP_PATHS)
//                    .append(File.separator)
                    .append("cov")
                    .append(UUID.randomUUID())
                    .append(i + 1)
                    .append(".")
                    .append(SPLIT_FILE_EXT[i])
                    .toString();
            readAndSaveSubFile(fis, covTypeHead.fileLens[i], filePath);
            split_file_names[i] = filePath;
        }
        fis.close();
        return split_file_names;
    }

    //读取并且分别存储内部文件
    private static void readAndSaveSubFile(FileInputStream fis, long fileLen, String filePath) throws IOException {
        long fileLen1 = fileLen;
        int len1 = 0;
        byte[] fileByteArray1 = new byte[1024];
        long n = fileLen1 / 1024;//循环次数
        long last = fileLen1 % 1024;//最后一次读取的数据

        File saveDir = new File(filePath);
        if (!saveDir.getParentFile().exists()) {
            saveDir.getParentFile().mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(saveDir);

        for (int i = 0; i < n; i++) {
            len1 = fis.read(fileByteArray1);
            fos.write(fileByteArray1, 0, len1);
        }
        //最后一次读取，声明一个限制的数组来读取
        byte[] fileByteArrayLast1 = new byte[(int) last];
        len1 = fis.read(fileByteArrayLast1);
        fos.write(fileByteArrayLast1, 0, len1);
        fos.close();
    }

    private static void merge(String[] filePaths, String mergeFilePath) throws IOException {
        Vector<FileInputStream> v = new Vector<FileInputStream>();
        int len = filePaths.length;
        long[] lens = new long[len];
        File file = null;
        for (int i = 0; i < len; i++) {
            file = new File(filePaths[i]);
            lens[i] = file.length();
            v.add(new FileInputStream(file));
            //System.out.println(file.getName() + " : " + file.length());
        }
        CovTypeHead covTypeHead = new CovTypeHead(1, lens);
        byte[] typeHeadArray = covTypeHead.toByteArray();
        //System.out.println(Arrays.toString(typeHeadArray));

        Enumeration<FileInputStream> en = v.elements();
        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream(mergeFilePath);
        //先写入头
        fos.write(typeHeadArray);
        //再写入三个文件
        byte[] buf = new byte[1024];
        int len1 = 0;
        while ((len1 = sis.read(buf)) != -1) {
            fos.write(buf, 0, len1);
        }
        fos.close();
        sis.close();
    }

    //缓存（写入临时文件，不是正路，正确思考应该是写入部分数据就可以开始播放）
    public static String getTempVideoFilePath(String covFileName) {
        try {
            String[] splitFilesNames = MergeFileTest.split(covFileName);
            return splitFilesNames[2];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
