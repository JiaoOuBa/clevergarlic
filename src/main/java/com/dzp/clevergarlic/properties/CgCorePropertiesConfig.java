package com.dzp.clevergarlic.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 核心配置开启配置
 * @Auther ck
 * @Date 2020/7/1 14:09
 * @Desc
 */

@Configuration
@EnableConfigurationProperties(CgCoreProperties.class)
public class CgCorePropertiesConfig {

}
