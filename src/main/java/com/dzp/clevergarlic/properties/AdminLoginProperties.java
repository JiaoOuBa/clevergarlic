package com.dzp.clevergarlic.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 登陆配置
 * @Auther ck
 * @Date 2020/7/28 13:38
 * @Desc
 */

@Component
@ConfigurationProperties(prefix = "fc.login")
public class AdminLoginProperties {

    private String host;

    private String platform;

    private String key;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
