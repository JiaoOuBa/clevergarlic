package com.dzp.clevergarlic.service.admin;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.*;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanInfoResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.ReadyCommitResponse;
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

    /**
     * 确认
     * @param request
     * @return
     */
    String reviewPlan(ReviewPlanRequest request);

    /**
     * 预测参数列表
     * @param request
     * @return
     */
    PageUtil<ReadyCommitResponse> readyCommitList(ReviewPlanListRequest request);
}
