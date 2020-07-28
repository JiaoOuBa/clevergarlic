package com.dzp.clevergarlic.entity;

import com.dzp.clevergarlic.config.interceptor.CommonConstant;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 请求头
 * @Auther ck
 * @Date 2020/7/27 14:45
 * @Desc
 */
public interface BaseHeader {

    /**
     * 获取响应头
     * @return 响应头信息
     */
    Map<String, Collection<String>> getHeader();

    /**
     * 设置响应头
     * @param header 响应头信息
     */
    void setHeader(Map<String, Collection<String>> header);

    /**
     * 获取token
     * @return token
     */
    default String getToken() {
        if (CollectionUtils.isEmpty(getHeader().get(CommonConstant.HEADER_AUTHORIZATION))) {
            return null;
        }
        Object[]authorization = getHeader().get(CommonConstant.HEADER_AUTHORIZATION).toArray();
        return authorization.length == 0? null : authorization[0].toString();
    }
}
