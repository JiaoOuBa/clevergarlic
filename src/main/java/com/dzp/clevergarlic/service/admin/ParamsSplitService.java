package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.ParamsUnit;

import java.util.List;

/**
 * 参数拆份服务类
 * @Auther ck
 * @Date 2020/8/20 18:39
 * @Desc
 */
public interface ParamsSplitService {

    /**
     * 租金参数拆分（按单楼）
     * @param planId
     * @param buildingId
     * @return
     */
    List<ParamsUnit> leaseSplit(String planId, String buildingId);

    /**
     * 招商参数拆分（按单楼）
     * @param planId
     * @param buildingId
     * @return
     */
    List<ParamsUnit> businessSplit(String planId, String buildingId);
}
