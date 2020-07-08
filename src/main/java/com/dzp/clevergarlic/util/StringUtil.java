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
}
