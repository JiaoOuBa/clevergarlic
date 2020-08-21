package com.dzp.clevergarlic.mapper.admin;

import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.EditLeaseFeeRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.BuildingUnit;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeForm;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeInfoResponse;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeasePrice;
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
     * @param form
     */
    void insertLeaseFee(LeaseFeeForm form);

    /**
     * 修改
     * @param form
     */
    void updateLeaseFee(LeaseFeeForm form);

    /**
     * 详情
     * @param id
     * @return
     */
    List<LeaseFeeInfoResponse> getLeaseFeeInfo(@Param("id") String id);

    /**
     * 删除
     * @param ids
     */
    void deleteLeaseFee(@Param("ids") List<String> ids);

    /**
     * 删除子表-租金单价信息
     * @param leaseId
     */
    void deleteLeasePrice(@Param("leaseId") String leaseId);

    /**
     * 新增子表-租金单价信息
     * @param price
     */
    void insertLeasePrice(LeasePrice price);

    /**
     * 根据计划查租金参数
     * @param planId
     * @param deleted
     * @return
     */
    List<String> countLeaseByPlan(@Param("planId") String planId, @Param("deleted") Integer deleted);

    /**
     * 根据租金参数id获取单价集合
     * @param leaseFeeId
     * @return
     */
    List<LeasePrice> getLeasePriceByLeaseId(@Param("leaseFeeId") String leaseFeeId);

    /**
     * 获取整楼单元集合
     * @param buildingId
     * @return
     */
    List<BuildingUnit> getUnitByBuilding(@Param("buildingId") String buildingId);
}
