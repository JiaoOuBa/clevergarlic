package com.dzp.clevergarlic.util;

import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.LongIdKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * 生成序列 uuid
 * @Auther ck
 * @Date 2020/7/30 10:21
 * @Desc
 */
@Component
public class LongIdUtil {

    @Autowired
    RedisService redisService;

    private static RedisService redis;

    @PostConstruct
    public void getRedis() {
        redis = redisService;
    }

    private static final String idFirst = "10000001";// 初始值
    private static final String idSuffix = "0001";

    public synchronized static long uuId() {

        LongIdKey idKey = LongIdKey.getByUUID;
        String id = redis.get(idKey,"uuid");
        if (id == null) {
            redis.set(idKey,"uuid","1000" + idSuffix);
            id = idFirst;
        }

        String newId = String.valueOf(Long.parseLong(id) + 1);
        redis.set(idKey,"uuid",newId);
        return Long.parseLong(newId);

        /*String nanoRandom = System.nanoTime() + "" + 1;
        int hash = Math.abs(UUID.randomUUID().hashCode());
        int needAdd = 19 - String.valueOf(hash).length() + 1;
        return Long.valueOf(hash + "" + nanoRandom.substring(needAdd));*/
    }
}
