package com.dzp.clevergarlic.redis.admin;

import com.dzp.clevergarlic.redis.BasePrefix;

/**
 * 登陆验证码prefix
 * @Auther ck
 * @Date 2020/8/13 10:55
 * @Desc
 */
public class LoginCodeKey extends BasePrefix {

    public LoginCodeKey(String prefix) {
        super(prefix);
    }

    public LoginCodeKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static LoginCodeKey getByCode = new LoginCodeKey( 60,"");

    public static LoginCodeKey withExpire(int expireSeconds) {
        return new LoginCodeKey(expireSeconds, "loginCode");
    }
}
