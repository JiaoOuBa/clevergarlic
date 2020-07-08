package com.dzp.clevergarlic.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成序列号工具类
 * @Auther ck
 * @Date 2020/7/8 10:53
 * @Desc
 */
public class CodeUtil {

    /**
     * yyyyMMddHHmmss+四位随机数
     *
     * @return
     */
    public static String getSerialNumber() {
        String serialNumber = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = formatter.format(new Date());
        int x = (int) (Math.random() * 900) + 100;
        serialNumber = dateStr + x;
        return serialNumber;
    }

    /**
     * yyyyMMddHHmmss+bit位随机数
     *
     * @return
     */
    public static String getSerialNumberByNumber(int bit) {
        int fillNumber = 1;
        for (int i = 0; i < bit - 1; i++)
            fillNumber = 10 * fillNumber;
        String serialNumber = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = formatter.format(new Date());
        int x = (int) (Math.random() * 9 * fillNumber) + fillNumber;
        serialNumber = dateStr + x;
        return serialNumber;
    }

    /**
     * yyyyMMdd+bit位随机数
     *
     * @return
     */
    public static String getSerialNumberNoDateByNumber(int bit) {
        int fillNumber = 1;
        for (int i = 0; i < bit - 1; i++)
            fillNumber = 10 * fillNumber;
        String serialNumber = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateStr = formatter.format(new Date());
        int x = (int) (Math.random() * 9 * fillNumber) + fillNumber;
        serialNumber = dateStr + x;
        return serialNumber;
    }

    /**
     * bit位随机数
     *
     * @return
     */
    public static String getSerialNumberNoTimeByNumber(int bit) {
        int fillNumber = 1;
        for (int i = 0; i < bit - 1; i++)
            fillNumber = 10 * fillNumber;
        int serialNumber = (int) (Math.random() * 9 * fillNumber) + fillNumber;
        return String.valueOf(serialNumber);
    }

}
