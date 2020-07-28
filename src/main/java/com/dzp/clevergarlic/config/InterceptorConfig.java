package com.dzp.clevergarlic.config;

import com.dzp.clevergarlic.config.interceptor.AdminTokenInterceptor;
import com.dzp.clevergarlic.config.interceptor.CORSInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * all请求拦截器配置
 * @Auther ck
 * @Date 2020/7/27 16:23
 * @Desc
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Bean
    public CORSInterceptor corsInterceptor() {
        return new CORSInterceptor();
    }

    @Bean
    public AdminTokenInterceptor adminTokenInterceptor() {
        return new AdminTokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(corsInterceptor())
                // 拦截所有请求
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**").order(1);

        registry.addInterceptor(adminTokenInterceptor())
                // 拦截所有admin请求
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/error", "/swagger-ui.html/**").order(2);

        /*registry.addInterceptor(accessInterceptor())
                // 拦截所有请求
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**").order(4);*/

    }
}
