package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.config.UserContext;
import com.dzp.clevergarlic.dao.RegionRepository;
import com.dzp.clevergarlic.dto.RegionDTO.CheckRegionRequest;
import com.dzp.clevergarlic.dto.RegionDTO.CheckRegionResponse;
import com.dzp.clevergarlic.dto.common.ExecuteSqlRequest;
import com.dzp.clevergarlic.entity.Region;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.mapper.common.CommonMapper;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.LoginCodeKey;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.admin.CommonService;
import com.dzp.clevergarlic.util.LanguageUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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

    @Autowired
    RegionRepository regionRepository;

    /**
     * sql脚本
     * @param request
     * @return
     */
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

    /**
     * 生成能坚持一天的验证码
     * @return
     */
    @Override
    public String generateCode() {

        redisService.set(LoginCodeKey.withExpire(86400), "CKSK", "Special for development ~~~");
        return "Code 'CKSK' Ready !";
    }

    /**
     * 检验地区信息是否正确并返回id
     * @param request
     * @return
     */
    @Override
    public ResultVo<CheckRegionResponse> checkRegion(CheckRegionRequest request) {
        String type = UserContext.getLanguageType().get();

        CheckRegionResponse response = new CheckRegionResponse();

        // 1 省市区都填的验证
        if (ObjectUtils.isNotEmpty(request.getProvince()) &&
            ObjectUtils.isNotEmpty(request.getCity()) &&
            ObjectUtils.isNotEmpty(request.getArea())) {

            Region byProvince = regionRepository.findByAreaName(request.getProvince());
            if (byProvince == null) {
                return Result.error(ExceptionMsg.FAILED, LanguageUtil.getMsg(type, Collections.singletonList("msg009")));
            }
            Region byCity = regionRepository.findByAreaName(request.getCity());
            if (byCity == null || !byProvince.getId().equals(byCity.getParentId())) {
                return Result.error(ExceptionMsg.FAILED, LanguageUtil.getMsg(type, Collections.singletonList("msg010")));
            }
            Region byArea = regionRepository.findByAreaName(request.getArea());
            if (byArea == null || !byCity.getId().equals(byArea.getParentId())) {
                return Result.error(ExceptionMsg.FAILED, LanguageUtil.getMsg(type, Collections.singletonList("msg011")));
            }

            response.setProvinceId(byProvince.getId());
            response.setCityId(byCity.getId());
            response.setAreaId(byArea.getId());
        }
        return Result.success(ExceptionMsg.SUCCESS, response, type);
    }


}
