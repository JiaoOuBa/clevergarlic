package com.dzp.clevergarlic.redis.admin;

import com.dzp.clevergarlic.redis.BasePrefix;

/**
 * 测试
 * @Auther ck
 * @Date 2020/7/20 9:47
 * @Desc
 */
public class TestKey extends BasePrefix {
    public TestKey(String prefix) {
        super(prefix);
    }

    public TestKey(Long expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static TestKey withExpire() {
        return new TestKey("test");
    }
}
