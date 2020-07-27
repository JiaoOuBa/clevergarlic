package com.dzp.clevergarlic.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;

/**
 * 时间转换工具类
 * @Auther ck
 * @Date 2020/7/1 16:05
 * @Desc
 */
public class DateUtil {

    /**
     * 把符合日期格式的字符串转换为日期类型
     *
     * @param dateStr 转换的字符串
     * @param format  格式
     * @return 返回日期类型
     */
    public static Date getStringToDate(String dateStr, String format) {
        Date d = null;
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            d = formater.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 将 获取指定格式的当前时间的字符串
     *
     * @param format 指定的格式
     * @return 返回字符串
     */
    public static String getDateToString(String format, Date data) {
        if (data == null) {
            return null;
        }
        SimpleDateFormat formater = new SimpleDateFormat(format);
        return formater.format(data);
    }

    /**
     * 获取指定格式的Date类型时间
     * @param format
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getDateFormat(String format, Date date) {
        Date res = null;

        if (date == null) {return null;}
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(date);
        try {
            res =  sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 将 获取指定格式的当前时间的字符串
     *
     * @param format 指定的格式
     * @return 返回字符串
     */
    public static String getNewDateToString(String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        return formater.format(new Date());
    }

    /**
     * 将java.sql.Timestamp对象转化为String字符串
     *
     * @param time      要格式的java.sql.Timestamp对象
     * @param strFormat 输出的String字符串格式的限定（如："yyyy-MM-dd HH:mm:ss"）
     * @return 表示日期的字符串
     */
    public static String dateToStr(Timestamp time, String strFormat) {
        if (time == null) {
            return null;
        }
        SimpleDateFormat df = new SimpleDateFormat(strFormat);
        return df.format(time);
    }

    /**
     * 将String字符串转换为java.sql.Timestamp格式日期,用于数据库保存
     *
     * @param strDate    表示日期的字符串
     * @param dateFormat 传入字符串的日期表示格式（如："yyyy-MM-dd HH:mm:ss"）
     * @return java.sql.Timestamp类型日期对象（如果转换失败则返回null）
     */
    public static Timestamp strToSqlDate(String strDate, String dateFormat) {
        if (StringUtils.isBlank(strDate)) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Timestamp(date.getTime());
    }

    /**
     * 将String字符串的时间,格式化成"yyyy-MM-dd",并自动补全月和日的零
     *
     * @param strDate 字符串日期
     * @return
     */
    public static String dateFormat(String strDate) {
        if (StringUtils.isNotBlank(strDate)) {
            String[] dateArr = strDate.replaceAll("/", "-").split("-");
            String newDate;
            if (dateArr.length == 2) {
                newDate = dateArr[0] + "-" + (dateArr[1].length() == 2 ? dateArr[1] : "0" + dateArr[1]);
            } else {
                newDate = dateArr[0] + "-" + (dateArr[1].length() == 2 ? dateArr[1] : "0" + dateArr[1]) +
                        "-" + (dateArr[2].length() == 2 ? dateArr[2] : "0" + dateArr[2]);
            }
            return newDate;
        } else {
            return null;
        }
    }

    /**
     * 计算两个时间之间的年月
     *
     * @param time1 时间1
     * @param time2 时间2
     * @return
     */
    public static Period getYearMonth(String time1, String time2) {
        if (StringUtils.isNotBlank(time1) && StringUtils.isNotBlank(time2)) {
            return Period.between(LocalDate.parse(dateFormat(time1)), LocalDate.parse(dateFormat(time2)));
        } else {
            return null;
        }
    }
}
