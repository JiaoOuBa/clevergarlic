package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.DelLeaseFeeRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.EditLeaseFeeRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeInfoResponse;

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

    /**
     * 详情
     * @param id
     * @return
     */
    LeaseFeeInfoResponse getLeaseFeeInfo(String id);

    /**
     * 删除
     * @param request
     */
    void deleteLeaseFee(DelLeaseFeeRequest request);
}
