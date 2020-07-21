package com.dzp.clevergarlic.mapper.admin;

import com.dzp.clevergarlic.dto.admin.logDTO.SysLogRequest;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * 存储系统日志mapper
 * @Auther ck
 * @Date 2020/7/6 10:18
 * @Desc
 */
@Repository
public interface SysLogMapper {

    void saveLog(SysLogRequest request);
}
