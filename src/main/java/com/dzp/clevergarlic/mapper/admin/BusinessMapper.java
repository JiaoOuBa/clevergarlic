package com.dzp.clevergarlic.mapper.admin;

import com.dzp.clevergarlic.dto.admin.businessDTO.response.BusinessForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 招商预测参数
 * @Auther ck
 * @Date 2020/7/22 10:08
 * @Desc
 */

@Repository
public interface BusinessMapper {

    /**
     * 新增
     * @param form
     */
    void insertBusiness(BusinessForm form);

    /**
     * 根据计划查招商参数
     * @param planId
     * @param deleted
     * @return
     */
    Integer countBusinessByPlan(@Param("planId") String planId, @Param("deleted") Integer deleted);

    /**
     * 根据计划删除招商参数
     * @param planId
     * @param deleted
     */
    void deleteBusinessByPlan(@Param("planId") String planId, @Param("deleted") Integer deleted);

    /**
     * 详情
     * @param buildingId
     * @return
     */
    List<BusinessForm> getBusinessByPlan(@Param("buildingId") String buildingId);
}
