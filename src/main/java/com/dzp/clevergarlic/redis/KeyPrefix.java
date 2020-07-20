package com.dzp.clevergarlic.redis;

/**
 * reids前缀配置
 * @Auther ck
 * @Date 2020/7/17 15:54
 * @Desc
 */
public interface KeyPrefix {

    /**
     * redis 过期时间
     * @return 过期时间
     */
    Long expireSeconds();

    /**
     * redis key
     * @return 键前缀
     */
    String getPrefix();
}
