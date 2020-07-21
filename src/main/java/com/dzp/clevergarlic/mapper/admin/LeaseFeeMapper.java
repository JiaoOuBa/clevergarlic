package com.dzp.clevergarlic.mapper.admin;

import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.EditLeaseFeeRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeInfoResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 租金预测参数
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

    /**
     * 详情
     * @param id
     * @return
     */
    LeaseFeeInfoResponse getLeaseFeeInfo(@Param("id") String id);

    /**
     * 删除
     * @param ids
     */
    void deleteLeaseFee(@Param("ids") List<String> ids);
}
