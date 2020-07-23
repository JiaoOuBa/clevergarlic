package com.dzp.clevergarlic.util;


import com.dzp.clevergarlic.SpringUtil;
import com.dzp.clevergarlic.enums.CodeNumberEnum;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.CodeKey;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 生成序列号工具类
 * @Auther ck
 * @Date 2020/7/8 10:53
 * @Desc
 */
@Component
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

/*----------------------------------------------分割线-----------------------------------------------------------------*/

    /**
     * 将对象属性转换为map集合
     * @param bean
     * @return
     */
    public static Map<String, Object> beanToMap(Object bean){
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key+"", beanMap.get(key));
            }
        }
        return map;
    }

    /**
     * 判断对象中是否都为空
     * @param bean
     * @return
     */
    public static Boolean beanIsNotNull(Object bean){
        List<String> s = Arrays.asList("status","driverId","vehicleId");
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (s.contains(key)){
                    continue;
                }
                if (beanMap.get(key) == null || beanMap.get(key) == ""){

                }else {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getCodeNumber(CodeNumberEnum codeNumberEnum) {
        return getCodeNumber(codeNumberEnum.getPrefix(),codeNumberEnum.getLength());
    }
    /**
     * 生成单号编码
     * @param prefix 前缀
     * @param maxLength 流水号长度
     * @return
     */
    public static synchronized String getCodeNumber(String prefix,Integer maxLength){
        RedisService redisService = SpringUtil.getBean(RedisService.class);

        String nowDate = getDateTime();

        String date = redisService.get(CodeKey.writePrefix(),"date");
        if (date == null || !date.equals(nowDate)) {

            redisService.set(CodeKey.writePrefix(),"date",nowDate);

            redisService.del(CodeKey.writePrefix("incr"));

        }

        //值++
        Long incr = redisService.incrBy(CodeKey.writePrefix("incr"), prefix, 1);

        return autoFillZero(prefix, nowDate, maxLength, incr);
    }

    private static String autoFillZero(String prefix, String nowDate, int maxLength, Long incr) {
        int num = maxLength - incr.toString().length();
        StringBuffer sb = new StringBuffer(prefix);
        sb.append(nowDate);
        for (int i = 0; i < num; i++) {
            sb.append("0");
        }
        sb.append(incr);
        return sb.toString();
    }

    /**
     * 生成固定长度随机码
     * @param n    长度
     */
    private static long getRandom(long n) {
        long min = 1,max = 10;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max- min-1)))) + min ;
        return rangeLong;
    }

    /**
     * 生成不带类别标头的编码
     * @param maxLength
     */
    private static synchronized String getCode(Integer maxLength){
        return String.valueOf(getRandom(maxLength));
    }

    /**
     * 生成时间戳
     */
    private static String getDateTime(){
        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());
    }

}
