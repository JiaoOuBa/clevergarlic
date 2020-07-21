package com.dzp.clevergarlic.service;

import com.dzp.clevergarlic.dto.admin.logDTO.SysLogRequest;

/**
 * 存储系统日志
 * @Auther ck
 * @Date 2020/7/6 10:15
 * @Desc
 */
public interface SysLogService {

    void saveSysLog(SysLogRequest request);
}
