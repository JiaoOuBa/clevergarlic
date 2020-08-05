package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.*;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanInfoResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.ReadyCommitResponse;
import com.dzp.clevergarlic.dto.admin.calculateDTO.BeforeCalculate;
import com.dzp.clevergarlic.dto.admin.calculateDTO.BuildingInfo;
import com.dzp.clevergarlic.dto.admin.calculateDTO.VersionInfo;
import com.dzp.clevergarlic.entity.PlanBuildingEntity;
import com.dzp.clevergarlic.enums.CodeNumberEnum;
import com.dzp.clevergarlic.enums.CommonStatusEnum;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.listener.event.ReadyCommitEvent;
import com.dzp.clevergarlic.mapper.admin.BudgetPlanMapper;
import com.dzp.clevergarlic.service.admin.BudgetPlanService;
import com.dzp.clevergarlic.util.CodeUtil;
import com.dzp.clevergarlic.util.DateUtil;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import com.dzp.clevergarlic.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 预算计划
 * @Auther ck
 * @Date 2020/7/22 13:54
 * @Desc
 */

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    @Autowired
    Sid sid;

    @Autowired
    BudgetPlanMapper budgetPlanMapper;

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 计划列表
     * @param request
     * @return
     */
    @Override
    public PageUtil<PlanListResponse> getPlanList(GetPlanListRequest request) {

        Map<String, Object> map = new HashMap<>();
        if (ObjectUtils.isNotEmpty(request.getPlanName())) {
            map.put("planName", request.getPlanName());
        }
        if (ObjectUtils.isNotEmpty(request.getStatus())) {
            map.put("status",request.getStatus());
        }
        if (ObjectUtils.isNotEmpty(request.getStartDate())) {
            map.put("startDate", DateUtil.getDateToString("yyyy-MM-dd",request.getStartDate()));
        }
        if (ObjectUtils.isNotEmpty(request.getEndDate())) {
            map.put("endDate", DateUtil.getDateToString("yyyy-MM-dd",request.getEndDate()));
        }
        if (ObjectUtils.isNotEmpty(request.getAdminName())) {

            // TODO: 2020/7/24 根据adminName获取adminId
            Long adminId = 10000001L;
            map.put("adminId",adminId);
        }
        if (ObjectUtils.isNotEmpty(request.getPlanCode())) {
            map.put("planCode",request.getPlanCode());
        }
        // 分页查询
        PageInfo<PlanListResponse> infoList = PageHelper.startPage(request.getPage(), request.getPageSize()).doSelectPageInfo(() -> budgetPlanMapper.getPlanList(map));

        infoList.getList().forEach(res -> {
            if (res.getStatus() != null) {
                res.setStatusName(CommonStatusEnum.getMsgByCode(res.getStatus()));
            }
            if (res.getAdminId() != null) {
                res.setAdminName("name");
            }
        });
        return new PageUtil<>(infoList);
    }

    /**
     * 保存计划
     * @param request
     */
    @Override
    public String savePlan(SavePlanRequest request) {

        AtomicInteger sucNum = new AtomicInteger();
        request.setStatus(CommonStatusEnum.REVIEW_XJ.getCode());
        request.setAdminId(10000001L);

        if (ObjectUtils.isEmpty(request.getPlanId())) {// 新增

            request.setPlanId(sid.nextShort());

            // TODO: 2020/7/23 公司编号获取
            String companyCode = "";
            request.setPlanCode(CodeUtil.getCodeNumber(CodeNumberEnum.CODE_YCJH.getPrefix(), CodeNumberEnum.CODE_YCJH.getLength(),companyCode));
            request.setPlanVersion("v" + DateUtil.getDateTime());
            budgetPlanMapper.insertToPlan(request);

        } else {// 编辑

            budgetPlanMapper.updatePlan(request);
            budgetPlanMapper.deleteBuildingByPlanId(request.getPlanId());
        }

        // 存入计划子表-楼宇信息
        request.getPlanBuildingList().forEach(res -> {
            PlanBuildingEntity req = new PlanBuildingEntity();
            req.setPlanBuildingId(sid.nextShort());
            req.setPlanId(request.getPlanId());
            BeanUtils.copyProperties(res, req);
            budgetPlanMapper.insertToBuilding(req);
            sucNum.getAndIncrement();
        });

        if (sucNum.get() == request.getPlanBuildingList().size()) {
            return ExceptionMsg.SUCCESS.getMsg();
        } else {
            budgetPlanMapper.deleteBuildingByPlanId(request.getPlanId());
            throw new RuntimeException("保存楼宇信息失败");
        }
    }

    /**
     * 计划详情
     * @param planId
     * @return
     */
    @Override
    public PlanInfoResponse getPlanInfo(String planId) {

        PlanInfoResponse info = budgetPlanMapper.getPlanInfo(planId);
        if (info.getAdminId() != null) {
            info.setAdminName("name");
        }
        return info;
    }

    /**
     * 计划删除
     * @param request
     * @return
     */
    @Override
    public String deletePlan(DeletePlanRequest request) {

        request.getIds().forEach(res -> {

            PlanInfoResponse info = budgetPlanMapper.getPlanInfo(res);
            if (info == null) {
                throw new RuntimeException("选中的计划不存在");
            }

            budgetPlanMapper.deleteBuildingByPlanId(res);
            budgetPlanMapper.deletePlan(res);
        });
        return ExceptionMsg.SUCCESS.getMsg();
    }

    /**
     * 计划确认
     * @param request
     * @return
     */
    @Override
    public String reviewPlan(ReviewPlanRequest request) {

        if (request.getOperation() == 1) {

            PlanInfoResponse info = budgetPlanMapper.getPlanInfo(request.getPlanId());
            if (!CommonStatusEnum.REVIEW_XJ.getCode().equals(info.getStatus())) {
                throw new RuntimeException("状态错误，不可确认！");
            }

            Long adminId = 10000001L;
            Map<String, Object> map = new HashMap<>();
            map.put("planId",request.getPlanId());
            map.put("status",CommonStatusEnum.REVIEW_YQR.getCode());
            map.put("adminId",adminId);
            budgetPlanMapper.reviewPlan(map);

            // publisher.publishEvent(new ReadyCommitEvent("计划确认，生成代办信息",request.getPlanId(),request.getOperation(),adminId));
        }
        return ExceptionMsg.SUCCESS.getMsg();
    }

    /**
     * 预测参数列表
     * @param request
     * @return
     */
    @Override
    public PageUtil<ReadyCommitResponse> readyCommitList(ReviewPlanListRequest request) {

        Map<String, Object> map = new HashMap<>();
        if (ObjectUtils.isNotEmpty(request.getPlanName())) {
            map.put("planName", request.getPlanName());
        }
        if (ObjectUtils.isNotEmpty(request.getStatus())) {
            map.put("status",request.getStatus());
        }
        if (ObjectUtils.isNotEmpty(request.getStartDate())) {
            map.put("startDate", DateUtil.getDateToString("yyyy-MM-dd",request.getStartDate()));
        }
        if (ObjectUtils.isNotEmpty(request.getEndDate())) {
            map.put("endDate", DateUtil.getDateToString("yyyy-MM-dd",request.getEndDate()));
        }
        if (ObjectUtils.isNotEmpty(request.getPlanCode())) {
            map.put("planCode",request.getPlanCode());
        }
        if (ObjectUtils.isNotEmpty(request.getParamType())) {
            map.put("paramType",request.getParamType());
        }
        if (ObjectUtils.isNotEmpty(request.getBuildingName())) {
            map.put("buildingName",request.getBuildingName());
        }
        // 分页查询
        PageInfo<ReadyCommitResponse> infoList = PageHelper.startPage(request.getPage(), request.getPageSize()).doSelectPageInfo(() -> budgetPlanMapper.readyCommitList(map));
        return new PageUtil<>(infoList);
    }

    /**
     * 计算
     * @describe 计算接口：将计划/参数的版本号统一成唯一的版本号作为键传给BI，最终会通过此版本号和计划id拿到结果
     * @param request
     */
    @Override
    public void calculate(CalculateRequest request) {

        BeforeCalculate beforeCalculate = budgetPlanMapper.getBeforeCalculate(request.getPlanId());
        for (BuildingInfo building : beforeCalculate.getBuildingParamData()) {

            // TODO: 2020/8/5 写入租金/招商参数

        }

        // 版本号记录
        VersionInfo versionInfo = budgetPlanMapper.getVersionInfo(request.getPlanId());
        versionInfo.setColumnId(sid.nextShort());
        Integer res = budgetPlanMapper.insertVersion(versionInfo);
        if (res <= 0) {
            throw new RuntimeException("版本记录失败！");
        }
        beforeCalculate.setVersion(versionInfo.getColumnId());

        // 调外部接口参与计算
    }
}
