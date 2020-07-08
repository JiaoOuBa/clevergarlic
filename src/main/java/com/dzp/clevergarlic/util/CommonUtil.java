package com.dzp.clevergarlic.util;

import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 公共工具类
 * @Auther ck
 * @Date 2020/7/3 11:09
 * @Desc
 */
public class CommonUtil {


    /**
     * 判断文件后缀名是否是传入的值
     *
     * @param file
     * @param type
     * @return
     */
    public static Boolean judgeFileType(MultipartFile file, String type) {
        String fileName = file.getOriginalFilename();
        String suffer = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());
        return type.equals(suffer);
    }

    /**
     * 获取当前日期（yyyy-MM-dd）
     *
     * @return
     */
    public static String getDateNow() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }

    /**
     * 获取当前日期（yyyy-MM-dd HH:mm:ss）
     *
     * @return
     */
    public static String getDateTimeNow() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
