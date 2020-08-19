package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.*;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.BuildingListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanInfoResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.ReadyCommitResponse;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.util.PageUtil;

import java.util.List;

/**
 * 预算计划
 * @Auther ck
 * @Date 2020/7/22 13:53
 * @Desc
 */

public interface BudgetPlanService {

    /**
     * 列表
     * @param request
     * @return
     */
    PageUtil<PlanListResponse> getPlanList(GetPlanListRequest request);

    /**
     * 保存
     * @param request
     */
    ResultVo savePlan(SavePlanRequest request, String type);

    /**
     * 详情
     * @param planId
     * @return
     */
    PlanInfoResponse getPlanInfo(String planId);

    /**
     * 删除
     * @param request
     * @return
     */
    ResultVo deletePlan(DeletePlanRequest request, String type);

    /**
     * 确认
     * @param request
     * @return
     */
    ResultVo reviewPlan(ReviewPlanRequest request, String type);

    /**
     * 预测参数列表
     * @param request
     * @return
     */
    PageUtil<ReadyCommitResponse> readyCommitList(ReviewPlanListRequest request);

    /**
     * 计算
     * @param request
     */
    ResultVo calculate(CalculateRequest request, String type);

    /**
     * 取消计算
     * @param request
     * @return
     */
    ResultVo cancelCalculate(CalculateRequest request, String type);

    /**
     * 计划预览
     * @param planId
     * @return
     */
    ResultVo planPreview(String planId, String type);

    /**
     * 新增初始页-楼宇列表
     * @return
     */
    List<BuildingListResponse> getBuildingList();

}
