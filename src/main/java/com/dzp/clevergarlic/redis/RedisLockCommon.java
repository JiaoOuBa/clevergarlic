package com.dzp.clevergarlic.redis;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Redis分布式锁
 * @Auther ck
 * @Date 2020/7/15 11:35
 * @Desc 方式：直接使用Redis实现
 */

@Component
public class RedisLockCommon {

    @Autowired
    RedisTemplate<String, String> redisTemplate;


    /**
     * 加锁
     * @param key 唯一标识
     * @param value 时间戳
     * @return
     */
    public Boolean getLock(String key, String value) {

        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }
        String currentValue = redisTemplate.opsForValue().get(key);
        if (StringUtils.isNotEmpty(currentValue) && Long.valueOf(currentValue) < System.currentTimeMillis()) {

            //获取上一个锁的时间 如果高并发的情况可能会出现已经被修改的问题  所以多一次判断保证线程的安全
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (StringUtils.isNotEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }
        return false;
    }


    /**
     * 解锁
     * @param key
     * @param value
     */
    public void closeLock(String key, String value) {

        String currentValue = redisTemplate.opsForValue().get(key);
        try {
            if (StringUtils.isNotEmpty(currentValue) && currentValue.equals(value)) {
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        } catch (Exception e) {

        }
    }


}
