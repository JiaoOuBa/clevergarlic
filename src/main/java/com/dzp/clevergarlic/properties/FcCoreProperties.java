package com.dzp.clevergarlic.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 核心配置
 * @Auther ck
 * @Date 2020/7/1 14:01
 * @Desc
 */

@ConfigurationProperties(prefix = "fc")
public class FcCoreProperties {

    // 权限相关配置
    private AuthProperties auth = new AuthProperties();

    public AuthProperties getAuth() {
        return auth;
    }

    public void setAuth(AuthProperties auth) {
        this.auth = auth;
    }
}
