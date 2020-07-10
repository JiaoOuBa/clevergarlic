package com.dzp.clevergarlic.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 * Copyright © 2018 Shanghai Yejia Digital Technology Co., Ltd. All rights reserved.
 * @author ck
 * @date 2020/07/09
 */
public class Md5Util {
    /**
     * MD5 加密方法
     * @param text 明文
     * @return String
     */
    public static String sign(String text) {
        //加密后的字符串
        String encodeStr = DigestUtils.md5Hex(text);

        return encodeStr;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5 密文
     * @return true/false
     */
    public static boolean verify(String text, String md5) throws Exception {
        //根据传入的密钥进行验证
        String md5Text = sign(text);
        if (md5Text.equalsIgnoreCase(md5)) {
            return true;
        }

        return false;
    }

    /**
     * 加密
     *
     * @param str
     * @return
     */
    public static String str2MD5(String str) {
        String ret = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            try {
                md.update(str.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e) {
                md.update(str.getBytes());
            }

            //md.update(str.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }

            ret = buf.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
