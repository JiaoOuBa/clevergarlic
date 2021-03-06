package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.admin.businessDTO.BusinessInfoResponse;
import com.dzp.clevergarlic.dto.admin.businessDTO.EditBusinessRequest;

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
    void editBusiness(EditBusinessRequest request);

    /**
     * 详情
     * @param id
     * @return
     */
    BusinessInfoResponse getBusinessInfo(String id);
}
