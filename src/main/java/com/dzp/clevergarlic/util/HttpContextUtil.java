package com.dzp.clevergarlic.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 获取httpRequest请求工具类
 * @Auther ck
 * @Date 2020/7/6 11:26
 * @Desc
 */
public class HttpContextUtil {

    private HttpContextUtil(){}
    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }
}
