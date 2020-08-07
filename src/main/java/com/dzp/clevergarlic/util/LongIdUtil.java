package com.dzp.clevergarlic.util;

import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.redis.RedisLockCommon;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.LongIdKey;
import com.dzp.clevergarlic.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 生成序列 uuid
 * @Auther ck
 * @Date 2020/7/30 10:21
 * @Desc
 */
@Component
@Slf4j
public class LongIdUtil {

    @Autowired
    RedisService redisService;

    @Autowired
    RedisLockCommon redisLock;

    private static RedisService redis;

    private static RedisLockCommon lock;

    @PostConstruct
    public void getRedis() {
        redis = redisService;
    }
    public void getLock() { lock = redisLock; }

    private static final String idFirst = "202000001";// 初始值
    private static final String idSuffix = "00001";

    public static long uuId() {

        int TIMEOUT = 30*1000;
        long time = System.currentTimeMillis() + TIMEOUT;

        try {

            // 加锁
            if (!lock.getLock("generateUuId",String.valueOf(time))) {
                throw new RuntimeException("redis锁被别人抢了~~");
            }

            LongIdKey idKey = LongIdKey.getByUUID;
            String id = redis.get(idKey,"uuid");
            if (id == null) {
                String year = getYear();
                redis.set(idKey,"uuid",year + idSuffix);
                id = idFirst;
            }

            // 一年一重置
            String idYear = id.substring(0, 4);
            if (!idYear.equals(getYear())) {
                redis.del(idKey, id);
                uuId();
            }

            String newId = String.valueOf(Long.parseLong(id) + 1);
            redis.set(idKey,"uuid",newId);
            return Long.parseLong(newId);
        } catch (Exception e) {
            log.error("用户id生成失败,错误信息====>" + e.getStackTrace()[0].toString());
            throw new RuntimeException("uuid生成失败！");
        } finally {

            //解锁
            lock.closeLock("generateUuId", String.valueOf(time));
        }


        /*String nanoRandom = System.nanoTime() + "" + 1;
        int hash = Math.abs(UUID.randomUUID().hashCode());
        int needAdd = 19 - String.valueOf(hash).length() + 1;
        return Long.valueOf(hash + "" + nanoRandom.substring(needAdd));*/
    }

    private static String getYear() {

        DateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(new Date());
    }
}
