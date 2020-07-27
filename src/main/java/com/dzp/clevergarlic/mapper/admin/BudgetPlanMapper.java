package com.dzp.clevergarlic.mapper.admin;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.ReadyCommitRequest;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanInfoResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.SavePlanRequest;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.ReadyCommitResponse;
import com.dzp.clevergarlic.entity.PlanBuildingEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 预算计划
 * @Auther ck
 * @Date 2020/7/22 14:27
 * @Desc
 */

@Repository
public interface BudgetPlanMapper {


    /**
     * 列表
     * @param map
     * @return
     */
    List<PlanListResponse> getPlanList(Map<String, Object> map);

    /**
     * 写入主表
     * @param request
     */
    void insertToPlan(SavePlanRequest request);

    /**
     * 写入计划-楼宇
     * @param req
     */
    void insertToBuilding(PlanBuildingEntity req);

    /**
     * 修改主表
     * @param request
     */
    void updatePlan(SavePlanRequest request);

    /**
     * 删除计划-楼宇
     * @param planId
     */
    void deleteBuildingByPlanId(@Param("planId") String planId);

    /**
     * 计划详情
     * @param planId
     * @return
     */
    PlanInfoResponse getPlanInfo(@Param("planId") String planId);

    void deletePlan(@Param("planId") String planId);

    /**
     * 根据planId修改状态
     * @param planId
     */
    void updateStatusById(@Param("planId") String planId, @Param("status") Integer status);

    /**
     * 批量写入代办信息
     * @param list
     */
    void insertToReadyCommit(List<ReadyCommitRequest> list);

    /**
     * 预测参数列表
     * @param map
     * @return
     */
    List<ReadyCommitResponse> readyCommitList(Map<String, Object> map);

    /**
     * 计划确认
     * @param map
     */
    void reviewPlan(Map<String, Object> map);
}
