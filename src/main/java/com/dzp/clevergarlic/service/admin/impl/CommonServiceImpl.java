package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.dto.common.ExecuteSqlRequest;
import com.dzp.clevergarlic.mapper.common.CommonMapper;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.LoginCodeKey;
import com.dzp.clevergarlic.service.admin.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 公共方法service实现类
 * @Auther ck
 * @Date 2020/7/3 17:57
 * @Desc
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    CommonMapper commonMapper;

    @Autowired
    RedisService redisService;

    @Override
    public Object executeSql(ExecuteSqlRequest request) {

        List<Map<String, Object>> mapList;
        List<Object> list = new ArrayList<>();
        for (String sql : request.getExecuteSqlList()) {
            mapList = commonMapper.executeSql(sql);
            list.add(mapList);
        }
        return list;

    }

    @Override
    public String generateCode() {


        redisService.set(LoginCodeKey.withExpire(86400), "CKSK", "Special for development ~~~");
        return "Code 'CKSK' Ready !";
    }
}
