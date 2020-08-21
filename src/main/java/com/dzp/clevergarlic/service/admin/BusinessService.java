package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.admin.businessDTO.BusinessInfoResponse;
import com.dzp.clevergarlic.dto.admin.businessDTO.EditBusinessRequest;
import com.dzp.clevergarlic.dto.admin.businessDTO.response.BusinessForm;
import com.dzp.clevergarlic.result.ResultVo;

import java.util.List;

/**
 * 招商预测参数
 * @Auther ck
 * @Date 2020/7/13 17:01
 * @Desc
 */
public interface BusinessService {

    /**
     * 提交/保存为草稿
     * @param request
     */
    ResultVo editBusiness(EditBusinessRequest request, String type);

    /**
     * 详情
     * @param buildingId
     * @return
     */
    ResultVo<BusinessInfoResponse> getBusinessInfo(String buildingId);
}
