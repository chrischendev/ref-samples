package com.aiway.monitor.collection.utils;

import java.math.BigDecimal;

/**
 * Created by Chris Chen
 * 2018/11/20
 * Explain: 数学工具
 */

public class MathUtils {

    /**
     * 求两个Double数值之间的差
     *
     * @param minuend     减数
     * @param subtraction 被减数
     * @return
     */
    public static Double subDouble(Double minuend, Double subtraction) {
        if (minuend == null) {
            minuend = 0D;
        }
        if (subtraction == null) {
            subtraction = 0D;
        }

        BigDecimal bdMinuend = new BigDecimal(Double.toString(minuend));
        BigDecimal bdSubtraction = new BigDecimal(Double.toString(subtraction));

        return bdMinuend.subtract(bdSubtraction).doubleValue();
    }

    /**
     * 求两个Double数值的和
     * @param value1
     * @param value2
     * @return
     */
    public static Double addDouble(Double value1, Double value2) {
        if (value1 == null) {
            value1 = 0D;
        }
        if (value2 == null) {
            value2 = 0D;
        }

        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(value1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(value2));

        return bigDecimal1.add(bigDecimal2).doubleValue();
    }

    /**
     * 两个Double数值相乘
     * @param value1
     * @param value2
     * @return
     */
    public static Double multiplyDouble(Double value1, Double value2) {
        if (value1 == null) {
            value1 = 0D;
        }
        if (value2 == null) {
            value2 = 0D;
        }

        BigDecimal bigDecimal1 = new BigDecimal(Double.toString(value1));
        BigDecimal bigDecimal2 = new BigDecimal(Double.toString(value2));

        return bigDecimal1.multiply(bigDecimal2).doubleValue();
    }

    /**
     * 两个Double数值相除
     * @param dividend 被除数
     * @param divisor 除数
     * @return
     */
    public static Double divideDouble(Double dividend, Double divisor) {
        if (dividend == null) {
            dividend = 0D;
        }
        if (divisor == null) {
            divisor = 0D;
        }

        BigDecimal bdDdividend = new BigDecimal(Double.toString(dividend));
        BigDecimal bdDivisor = new BigDecimal(Double.toString(divisor));

        return bdDdividend.divide(bdDivisor).doubleValue();
    }
}
