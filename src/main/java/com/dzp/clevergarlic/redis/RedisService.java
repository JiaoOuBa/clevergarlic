package com.dzp.clevergarlic.redis;
import com.dzp.clevergarlic.redis.admin.CodeKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * redis服务类
 * @Auther JiaoOuBa
 * @Date 2020/7/15 9:50
 * @Desc
 */

@Service
public class RedisService {

    @Autowired
    RedisTemplate<String, String> redisTemplate;


    /**
     * 获取缓存
     * @param key
     * @return
     */
    public String get(KeyPrefix prefix, final String key) {
        //生成真正的key
        String realKey  = prefix.getPrefix() + key;
        return redisTemplate.opsForValue().get(realKey);
    }

    /**
     * 为多个键分别取出它们的值
     * @param keys
     * @return
     */
    public List<String> multiGet(Collection<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(KeyPrefix prefix, final String key, String value) {
        boolean res = false;
        try {

            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            redisTemplate.opsForValue().set(realKey, value);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 更新缓存并返回旧值
     * @param key
     * @param value
     * @return
     */
    public String getAndSet(KeyPrefix prefix, final String key, String value) {
        String res = null;
        try {

            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            res = redisTemplate.opsForValue().getAndSet(realKey, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


    /**
     * 删除缓存
     * @param prefix
     * @return
     */
    public boolean del(KeyPrefix prefix) {
        boolean res = false;
        try {

            //生成真正的key
            String realKey  = prefix.getPrefix();
            redisTemplate.delete(realKey);
            res = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 获取传入key集合的总数
     * @param keys
     * @return
     */
    public Long existsCol(Collection<String> keys) {
        try {
            return redisTemplate.countExistingKeys(keys);
        } finally {
            close();
        }
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public Boolean exist(KeyPrefix prefix, String key) {
        try {

            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            return redisTemplate.hasKey(realKey);
        } finally {
            close();
        }
    }

    /**
     * 指定缓存失效时间
     * @param key
     * @param time 时间值
     * @param unit 时间单位
     * @return
     */
    public Boolean expire(KeyPrefix prefix, String key, long time, TimeUnit unit) {
        Boolean res = false;
        try {
            if (time > 0) {

                //生成真正的key
                String realKey  = prefix.getPrefix() + key;
                res =  redisTemplate.expire(realKey, time, unit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 断开连接
     * --虽然设置了连接池大小，但是治标不治本，还得close一下
     */
    public void close() {
        RedisConnectionUtils.unbindConnection(Objects.requireNonNull(redisTemplate.getConnectionFactory()));
    }

    /**
     * 指定增加num
     * @param prefix
     * @param key
     * @param i
     * @param <T>
     * @return
     */
    public <T> Long incrBy(KeyPrefix prefix, String key, int i) {
        try {
            //生成真正的key
            String realKey  = prefix.getPrefix() + key;
            return redisTemplate.opsForValue().increment(realKey, i);
        } finally {
            close();
        }
    }
}
