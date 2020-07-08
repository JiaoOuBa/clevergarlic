package com.dzp.clevergarlic.service;

import com.dzp.clevergarlic.dto.common.ExecuteSqlRequest;

/**
 * 公共方法service
 * @Auther ck
 * @Date 2020/7/3 17:56
 * @Desc
 */
public interface CommonService {

    /**
     * 执行sql
     * @param request
     */
    Object executeSql(ExecuteSqlRequest request);
}
