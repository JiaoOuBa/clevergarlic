package com.dzp.clevergarlic.redis.admin;

import com.dzp.clevergarlic.redis.BasePrefix;

/**
 * @Auther ck
 * @Date 2020/7/22 18:08
 * @Desc
 */
public class CodeKey extends BasePrefix {
    public CodeKey(String prefix) {
        super(prefix);
    }

    public CodeKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static CodeKey writePrefix(String prefix) {
        return new CodeKey((1*24*60+10)*60, prefix);
    }

    public static CodeKey writePrefix() {
        return new CodeKey((1*24*60+10)*60, "");
    }
}
