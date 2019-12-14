package com.chris.base.libs.utils;

import com.chris.base.libs.manager.UtilsManager;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * AiligouApp
 * com.alg.ailigouapp.library.utils
 * Created by Chris Chen on 2017/7/4 14:04.
 * Explain:时间处理工具类
 */

public class TimeUtils extends UtilsManager {
    public static SimpleDateFormat sdf = new SimpleDateFormat();
    public static String PATTERN1 = "yyyy年MM月dd日 HH时mm分ss秒";
    public static String PATTERN2 = "yyyy年MM月dd日";
    public static String PATTERN3 = "yyyy-MM-dd";
    public static String PATTERN4 = "yyyy-MM-dd hh:mm:ss";
    public static String PATTERN5 = "hh:mm:ss";

    /**
     * 格式化long时间戳
     *
     * @param timeStamp
     * @param pattern
     * @return
     */
    public static String format(long timeStamp, String pattern) {
        sdf.applyPattern(pattern);
        return sdf.format(timeStamp);
    }

    /**
     * 格式化date时间
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }


    /**
     * 把秒转为天/时/分/秒
     *
     * @param mss
     * @return
     */
    public static String formatDayHourMinuteSecond(long mss) {
        String DateTimes = null;
        long days = mss / (60 * 60 * 24);
        long hours = (mss % (60 * 60 * 24)) / (60 * 60);
        long minutes = (mss % (60 * 60)) / 60;
        long seconds = mss % 60;
        if (days > 0) {
            DateTimes = days + "天" + hours + "小时" + minutes + "分钟"
                    + seconds + "秒";
        } else if (hours > 0) {
            DateTimes = hours + "小时" + minutes + "分钟"
                    + seconds + "秒";
        } else if (minutes > 0) {
            DateTimes = minutes + "分钟"
                    + seconds + "秒";
        } else {
            DateTimes = seconds + "秒";
        }

        return DateTimes;
    }
}
