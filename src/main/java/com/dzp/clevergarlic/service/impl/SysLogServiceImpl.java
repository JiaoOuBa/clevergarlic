package com.dzp.clevergarlic.service.impl;

import com.dzp.clevergarlic.dto.admin.logDto.SysLogRequest;
import com.dzp.clevergarlic.mapper.admin.SysLogMapper;
import com.dzp.clevergarlic.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 存储系统日志
 * @Auther ck
 * @Date 2020/7/6 10:16
 * @Desc
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    SysLogMapper sysLogMapper;

    @Override
    public void saveSysLog(SysLogRequest request) {
        sysLogMapper.saveLog(request);
    }
}
