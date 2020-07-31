package com.dzp.clevergarlic.redis.admin;

import com.dzp.clevergarlic.redis.BasePrefix;

/**
 * @Auther ck
 * @Date 2020/7/30 10:24
 * @Desc
 */
public class LongIdKey extends BasePrefix {

    public LongIdKey(String prefix) {
        super(prefix);
    }

    public LongIdKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static LongIdKey getByUUID = new LongIdKey( 0,"");

    public static LongIdKey withExpire(int expireSeconds) {
        return new LongIdKey(expireSeconds, "uuid");
    }
}
