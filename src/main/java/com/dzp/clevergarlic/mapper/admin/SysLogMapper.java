package com.dzp.clevergarlic.mapper.admin;

import com.dzp.clevergarlic.dto.admin.logDto.SysLogRequest;
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

    @Insert("insert into tb_sys_log (log_id,user_id,user_name,operation,time,method,params,ip,error_msg) values (#{logId},#{userId},#{userName},#{operation},#{time},#{method},#{params},#{ip},#{errorMsg})")
    void saveLog(SysLogRequest request);
}
