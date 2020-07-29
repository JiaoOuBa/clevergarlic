package com.dzp.clevergarlic.redis.admin;

import com.dzp.clevergarlic.redis.BasePrefix;

/**
 * 后台登陆token
 * @Auther ck
 * @Date 2020/7/29 9:44
 * @Desc
 */
public class AdminTokenKey extends BasePrefix {

    public AdminTokenKey(String prefix) {
        super(prefix);
    }

    public AdminTokenKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static AdminTokenKey getByToken = new AdminTokenKey( 0,"token");

    public static AdminTokenKey withExpire(int expireSeconds) {
        return new AdminTokenKey(expireSeconds, "token");
    }
}
