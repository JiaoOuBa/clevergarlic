package com.dzp.clevergarlic.config.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cors跨域拦截器
 * @Auther ck
 * @Date 2020/7/27 16:23
 * @Desc
 */
public class CORSInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        /*
         * 允许的请求头类型: 包含请求的token 等
         */
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "6000"); //设置过期时间
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With," +
                "token, Content-Type, Authorization, device, version, platform");
        response.setHeader("Access-Control-Expose-Headers","Authorization");
        return true;
    }
}
