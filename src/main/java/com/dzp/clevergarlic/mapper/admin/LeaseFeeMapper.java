package com.dzp.clevergarlic.mapper.admin;

import com.dzp.clevergarlic.dto.admin.leaseFeeDto.EditLeaseFeeRequest;
import org.springframework.stereotype.Repository;

/**
 * 租金信息
 * @Auther ck
 * @Date 2020/7/13 14:44
 * @Desc
 */
@Repository
public interface LeaseFeeMapper {

    /**
     * 新增
     * @param request
     */
    void insertLeaseFee(EditLeaseFeeRequest request);

    /**
     * 修改
     * @param request
     */
    void updateLeaseFee(EditLeaseFeeRequest request);
}
