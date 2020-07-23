package com.dzp.clevergarlic.service.impl;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.DeletePlanRequest;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.GetPlanListRequest;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanInfoResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanListResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.SavePlanRequest;
import com.dzp.clevergarlic.entity.PlanBuildingEntity;
import com.dzp.clevergarlic.enums.CodeNumberEnum;
import com.dzp.clevergarlic.enums.CommonStatusEnum;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.mapper.admin.BudgetPlanMapper;
import com.dzp.clevergarlic.service.BudgetPlanService;
import com.dzp.clevergarlic.util.CodeUtil;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import com.dzp.clevergarlic.util.PageUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        request.setStatus(CommonStatusEnum.REVIEW_YQR.getCode());
        request.setAdminId(10000001L);

        if (ObjectUtils.isEmpty(request.getPlanId())) {// 新增

            request.setPlanId(sid.nextShort());
            request.setPlanCode(CodeUtil.getCodeNumber(CodeNumberEnum.CODE_YCJH.getPrefix(), CodeNumberEnum.CODE_YCJH.getLength()));
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

            if (this.getPlanInfo(res) == null) {
                throw new RuntimeException("选中的计划不存在");
            }

            budgetPlanMapper.deleteBuildingByPlanId(res);
            budgetPlanMapper.deletePlan(res);
        });
        return ExceptionMsg.SUCCESS.getMsg();
    }
}
