package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.RegionDTO.CheckRegionRequest;
import com.dzp.clevergarlic.dto.RegionDTO.CheckRegionResponse;
import com.dzp.clevergarlic.dto.common.ExecuteSqlRequest;
import com.dzp.clevergarlic.result.ResultVo;

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

    String generateCode();

    ResultVo<CheckRegionResponse> checkRegion(CheckRegionRequest request);
}
