package com.dzp.clevergarlic.redis;

/**
 * redis抽象类
 * @Auther ck
 * @Date 2020/7/17 15:55
 * @Desc
 */
public abstract class BasePrefix implements KeyPrefix {

    private Long expireSeconds;

    private String prefix;

    public BasePrefix(String prefix) {//0代表永不过期
        this(0L, prefix);
    }

    public BasePrefix( Long expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    public Long expireSeconds() {//默认0代表永不过期
        return expireSeconds;
    }

    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className+":" + prefix;
    }
}
