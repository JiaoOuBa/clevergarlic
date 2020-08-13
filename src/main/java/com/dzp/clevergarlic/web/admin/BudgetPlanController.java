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
public class BudgetPlanController extends BaseController{

    @Autowired
    BudgetPlanService budgetPlanService;

    @ApiOperation(value = "计划列表")
    @PostMapping(value = "/v1/getPlanList")
    public ResultVo<PageUtil<PlanListResponse>> getPlanList(@RequestBody GetPlanListRequest request) {
        String type = getLanguageType();
        try {

            return Result.success(budgetPlanService.getPlanList(request), type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

    @ApiOperation(value = "计划保存")
    @PostMapping(value = "/v1/savePlan")
    public ResultVo savePlan(@Valid @RequestBody SavePlanRequest request) {
        String type = getLanguageType();
        try {
            return budgetPlanService.savePlan(request, type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type,e);
        }
    }

    @ApiOperation(value = "计划详情")
    @GetMapping(value = "/v1/getPlanInfo")
    public ResultVo<PlanInfoResponse> getPlanInfo(@ApiParam("计划id") @RequestParam(value = "planId") String planId) {
        String type = getLanguageType();
        try {
            return Result.success(budgetPlanService.getPlanInfo(planId),type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,type,e);
        }
    }

    @ApiOperation(value = "计划删除")
    @PostMapping(value = "/v1/deletePlan")
    public ResultVo deletePlan(@Valid @RequestBody DeletePlanRequest request) {
        String type = getLanguageType();
        try {
            return budgetPlanService.deletePlan(request, type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,type,e);
        }
    }

    @ApiOperation(value = "计划确认")
    @PostMapping(value = "/v1/reviewPlan")
    public ResultVo reviewPlan(@Valid @RequestBody ReviewPlanRequest request) {
        String type = getLanguageType();
        try {
            return budgetPlanService.reviewPlan(request, type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,type,e);
        }
    }

    @ApiOperation(value = "计划预览（确认页面）")
    @GetMapping(value = "v1/planPreview")
    public ResultVo planPreview(@ApiParam("计划id") @RequestParam(value = "planId") String planId) {
        String type = getLanguageType();
        try {
            return budgetPlanService.planPreview(planId, type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

    @ApiOperation(value = "预测参数列表")
    @PostMapping(value = "/v1/readyCommitList")
    public ResultVo<PageUtil<ReadyCommitResponse>> readyCommitList(@RequestBody ReviewPlanListRequest request) {
        String type = getLanguageType();
        try {
            return Result.success(budgetPlanService.readyCommitList(request), type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

    @ApiOperation(value = "新增初始页-楼宇列表")
    @GetMapping(value = "/v1/getBuildingList")
    public ResultVo<List<BuildingListResponse>> getBuildingList() {
        String type = getLanguageType();
        try {
            List<BuildingListResponse> responses = null;
            return Result.success(type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

    @ApiOperation(value = "计算")
    @PostMapping(value = "/v1/calculate")
    public ResultVo calculate(@RequestBody CalculateRequest request) {
        String type = getLanguageType();
        try {
            return budgetPlanService.calculate(request, type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

    @ApiOperation(value = "取消计算")
    @PostMapping(value = "v1/cancelCalculate")
    public ResultVo cancelCalculate(@RequestBody CalculateRequest request) {
        String type = getLanguageType();
        try {
            return budgetPlanService.cancelCalculate(request, type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

}
