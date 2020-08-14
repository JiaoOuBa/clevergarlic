package com.dzp.clevergarlic.util;

import java.net.URLEncoder;

/**
 * String工具类
 * @Auther ck
 * @Date 2020/7/3 16:48
 * @Desc
 */
public class StringUtil {


    /**
     * 中文参数的乱码进行转码
     * @param
     * @return
     * @throws Exception
     */
    public static String StringToUTF8(String paramString) {
        if (paramString == null || paramString.equals("")) {
            return "";
        }
        try
        {
            String str = new String(paramString.getBytes(), "UTF-8");
            str = URLEncoder.encode(str, "UTF-8");
            return str;
        }
        catch (Exception localException)
        {
        }
        return "";
    }


    /**
     * 判断字符串是否为空
     * 包括是否为null，是否为空字符串，过滤完空格后是否为空字符串
     * @param str
     * @return
     */
    public static boolean IsAbsEmpty(final String str) {
        if (str == null) {
            return true;
        } else {
            return str.trim().isEmpty();
        }
    }

    /**
     * 将16进制转换为二进制
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}
