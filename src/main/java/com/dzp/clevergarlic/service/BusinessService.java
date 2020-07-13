package com.dzp.clevergarlic.service;

import com.dzp.clevergarlic.dto.admin.businessDto.EditBusinessRequest;

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
}
