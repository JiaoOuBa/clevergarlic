package com.dzp.clevergarlic.web.admin;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.*;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.BuildingListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanInfoResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.ReadyCommitResponse;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.admin.BudgetPlanService;
import com.dzp.clevergarlic.util.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 预算计划
 * @Auther ck
 * @Date 2020/7/22 13:17
 * @Desc
 */
@Api(value = "budgetPlan", description = "制定预算计划相关接口（ck）")
@RestController
@RequestMapping(value = "budgetPlan", produces = "application/json;charset=utf-8")
public class BudgetPlanController {

    @Autowired
    BudgetPlanService budgetPlanService;

    @ApiOperation(value = "计划列表")
    @PostMapping(value = "/v1/getPlanList")
    public ResultVo<PageUtil<PlanListResponse>> getPlanList(@RequestBody GetPlanListRequest request) {
        try {
            return Result.success(budgetPlanService.getPlanList(request));
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }

    @ApiOperation(value = "计划保存")
    @PostMapping(value = "/v1/savePlan")
    public ResultVo savePlan(@Valid @RequestBody SavePlanRequest request) {
        try {
            return Result.success(budgetPlanService.savePlan(request));
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }

    @ApiOperation(value = "计划详情")
    @GetMapping(value = "/v1/getPlanInfo")
    public ResultVo<PlanInfoResponse> getPlanInfo(@ApiParam("计划id") @RequestParam(value = "planId") String planId) {
        try {
            return Result.success(budgetPlanService.getPlanInfo(planId));
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }

    @ApiOperation(value = "计划删除")
    @PostMapping(value = "/v1/deletePlan")
    public ResultVo deletePlan(@Valid @RequestBody DeletePlanRequest request) {
        try {
            return Result.success(budgetPlanService.deletePlan(request));
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }

    @ApiOperation(value = "计划确认")
    @PostMapping(value = "/v1/reviewPlan")
    public ResultVo reviewPlan(@Valid @RequestBody ReviewPlanRequest request) {
        try {
            String msg = budgetPlanService.reviewPlan(request);
            return Result.success(msg);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }

    @ApiOperation(value = "预测参数列表")
    @PostMapping(value = "/v1/readyCommitList")
    public ResultVo<PageUtil<ReadyCommitResponse>> readyCommitList(@RequestBody ReviewPlanListRequest request) {
        try {
            return Result.success(budgetPlanService.readyCommitList(request));
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }

    @ApiOperation(value = "初始化页-楼宇列表")
    @GetMapping(value = "/v1/getBuildingList")
    public ResultVo<List<BuildingListResponse>> getBuildingList() {
        try {
            List<BuildingListResponse> responses = null;
            return Result.success();
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }

    @ApiOperation(value = "计算")
    @PostMapping(value = "/v1/calculate")
    public ResultVo calculate(@RequestBody CalculateRequest request) {
        try {
            budgetPlanService.calculate(request);
            return Result.success();
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, e);
        }
    }

}
