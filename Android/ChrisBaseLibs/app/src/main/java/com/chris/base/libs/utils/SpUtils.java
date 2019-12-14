package com.chris.base.libs.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.chris.base.libs.manager.UtilsManager;

/**
 * com.alg.ailigouapp.library.utils
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 17:32
 * Explain:SharedPreferences工具类
 */

public class SpUtils extends UtilsManager {
    private static SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext);

    /**
     * 保存一个SharedPreferences对象
     *
     * @param key
     * @param value
     */
    public static void save(String key, Object value) {
        if (value instanceof Integer) {
            sharedPreferences.edit().putInt(key, (Integer) value).commit();
        } else if (value instanceof Float) {
            sharedPreferences.edit().putFloat(key, (Float) value).commit();
        } else if (value instanceof Boolean) {
            sharedPreferences.edit().putBoolean(key, (Boolean) value).commit();
        } else if (value instanceof Long) {
            sharedPreferences.edit().putLong(key, (Long) value).commit();
        } else if (value instanceof String) {
            sharedPreferences.edit().putString(key, (String) value).commit();
        }
    }

    /**
     * 删除一个对象
     *
     * @param key
     */
    public static void remove(String key) {
        sharedPreferences.edit().remove(key).commit();
    }

    /**
     * 清空所有对象
     */
    public static void clear() {
        sharedPreferences.edit().clear().commit();
    }

    /**
     * 读取字符串
     *
     * @param key
     * @param defValue
     * @return
     */
    public static String read(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }

    /**
     * 读取int值
     *
     * @param key
     * @param defValue
     * @return
     */
    public static int readInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    /**
     * 读取float值
     *
     * @param key
     * @param defValue
     * @return
     */
    public static float readFloat(String key, float defValue) {
        return sharedPreferences.getFloat(key, defValue);
    }

    /**
     * 读取long值
     *
     * @param key
     * @param defValue
     * @return
     */
    public static long readLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }

    /**
     * 读取boolean值
     *
     * @param key
     * @param defValue
     * @return
     */
    public static boolean readBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }

}
