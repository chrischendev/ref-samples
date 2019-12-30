package com.chris.hmc.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Create by Chris Chan
 * Create on 2019/12/31 5:50
 * Use for:
 */
public class ObjUtils {
    /**
     * Object转换成字节数组
     * 待测试
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static byte[] getBytesFromObject(Serializable obj) throws IOException {
        if (obj == null) {
            System.out.println("没数据");
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        byte[] bytes = baos.toByteArray();
        oos.close();
        baos.close();
        return bytes;
    }
}
