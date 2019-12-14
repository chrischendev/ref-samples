package com.chris.javacv.newcodec;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class CovTypeHead {
    private static final int FILE_LENTH_BYTE_NUMER = 8;//文件长度数据包含的字节数
    public byte type;//文件类型
    public byte num;//组合的文件数
    public long[] fileLens;//每个文件的长度 字节数

    public CovTypeHead() {
    }

    public CovTypeHead(int type, long[] fileLens) {
        this.type = new Byte(String.valueOf(type));
        this.num = new Byte(String.valueOf(fileLens.length * FILE_LENTH_BYTE_NUMER));
        this.fileLens = fileLens;
        //System.out.println(Arrays.toString(fileLens));
    }

    public byte[] toByteArray() {
        int len = 2 + num;
        byte[] bytes = new byte[len];
        bytes[0] = type;
        bytes[1] = num;
        for (int i = 0; i < fileLens.length; i++) {
            long fileLen = fileLens[i];
            //System.out.println(fileLen);
            byte[] longBytes = longToBytes(fileLen);
            //System.out.println(Arrays.toString(longBytes));
            for (int n = 0; n < FILE_LENTH_BYTE_NUMER; n++) {
                bytes[i * FILE_LENTH_BYTE_NUMER + 2 + n] = longBytes[n];
            }
        }
        return bytes;
    }

    /**
     * byte数组转int类型的对象
     *
     * @param bytes
     * @return
     */
    public int Byte2Int(Byte[] bytes) {
        return (bytes[0] & 0xff) << 24
                | (bytes[1] & 0xff) << 16
                | (bytes[2] & 0xff) << 8
                | (bytes[3] & 0xff);
    }

    /**
     * int转byte数组
     *
     * @param num
     * @return
     */
    public byte[] IntToByte(int num) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) ((num >> 24) & 0xff);
        bytes[1] = (byte) ((num >> 16) & 0xff);
        bytes[2] = (byte) ((num >> 8) & 0xff);
        bytes[3] = (byte) (num & 0xff);
        return bytes;
    }

    //byte 数组与 long 的相互转换
    public byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.putLong(0, x);
        return buffer.array();
    }

    public static long bytesToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(bytes, 0, bytes.length);
        buffer.flip();//need flip
        return buffer.getLong();
    }

    //这里的26是暂定的 表示只能合并三个文件
    public static CovTypeHead get(byte[] byteArray) {
        if (byteArray.length != 26) {
            return null;
        }

        CovTypeHead covTypeHead = new CovTypeHead();
        //开始解析
        covTypeHead.type = byteArray[0];
        covTypeHead.num = byteArray[1];
        covTypeHead.fileLens = new long[3];
        for (int i = 0; i < 3; i++) {
            //将数组部分复制
            byte[] ofRange = Arrays.copyOfRange(byteArray, i * FILE_LENTH_BYTE_NUMER + 2, (i + 1) * FILE_LENTH_BYTE_NUMER + 2);
            covTypeHead.fileLens[i] = bytesToLong(ofRange);
        }
        return covTypeHead;
    }

}
