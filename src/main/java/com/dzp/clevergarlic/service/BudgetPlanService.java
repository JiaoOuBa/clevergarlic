package com.dzp.clevergarlic.service;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.DeletePlanRequest;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.GetPlanListRequest;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanInfoResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.SavePlanRequest;
import com.dzp.clevergarlic.util.PageUtil;

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
    String savePlan(SavePlanRequest request);

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
    String deletePlan(DeletePlanRequest request);
}
