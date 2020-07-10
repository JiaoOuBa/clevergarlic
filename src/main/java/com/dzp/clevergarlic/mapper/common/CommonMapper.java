package com.dzp.clevergarlic.mapper.common;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 公共方法mapper
 * @Auther ck
 * @Date 2020/7/3 18:02
 * @Desc
 */

@Repository
public interface CommonMapper {

    /**
     * 执行sql
     * @param sql
     * @return
     */
    List<Map<String, Object>> executeSql(@Param("sql") String sql);
}
