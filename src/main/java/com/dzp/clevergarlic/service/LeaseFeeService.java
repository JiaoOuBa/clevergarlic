package com.dzp.clevergarlic.service;

import com.dzp.clevergarlic.dto.admin.leaseFeeDto.EditLeaseFeeRequest;

/**
 * 租金预测参数
 * @Auther ck
 * @Date 2020/7/13 13:11
 * @Desc
 */
public interface LeaseFeeService {

    /**
     * 提交/保存为草稿
     * @param request
     */
    void editLeaseFee(EditLeaseFeeRequest request);
}
