package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.ConfirmRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.DelLeaseFeeRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.EditLeaseFeeRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.BuildingUnit;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeInfoResponse;
import com.dzp.clevergarlic.result.ResultVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    List<LeaseFeeInfoResponse> getLeaseFeeInfo(String id);

    /**
     * 删除
     * @param request
     */
    void deleteLeaseFee(DelLeaseFeeRequest request);

    /**
     * 确认/反确认
     * @param request
     * @return
     */
    ResultVo confirm(ConfirmRequest request);

    /**
     * 获取整楼单元集合
     * @param buildingId
     * @return
     */
    List<BuildingUnit> getUnitByBuilding(@Param("buildingId") String buildingId);
}
