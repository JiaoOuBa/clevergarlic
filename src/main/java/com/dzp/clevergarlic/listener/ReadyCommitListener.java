package com.dzp.clevergarlic.listener;

import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.request.ReadyCommitRequest;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanBuildingResponse;
import com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response.PlanInfoResponse;
import com.dzp.clevergarlic.enums.BudgetParamEnum;
import com.dzp.clevergarlic.enums.CommonStatusEnum;
import com.dzp.clevergarlic.listener.event.ReadyCommitEvent;
import com.dzp.clevergarlic.mapper.admin.BudgetPlanMapper;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 代办列表监听器
 * @Auther ck
 * @Date 2020/7/23 15:23
 * @Desc
 */

@Component
public class ReadyCommitListener implements ApplicationListener<ReadyCommitEvent> {

    @Autowired
    Sid sid;

    @Autowired
    BudgetPlanMapper budgetPlanMapper;

    @Override
    public void onApplicationEvent(ReadyCommitEvent event) {
        try {

            if (event.getType() == 1) {
                //计划确认，自动生成待办列表信息
                PlanInfoResponse info = budgetPlanMapper.getPlanInfo(event.getPlanId());
                if (info != null && CommonStatusEnum.REVIEW_YQR.getCode().equals(info.getStatus())) {

                    info.getPlanBuildingList().forEach(res -> {

                        List<ReadyCommitRequest> list = new ArrayList<>(2);// 最终得到的代办信息list
                        getReadyCommitRequest(event, res, BudgetParamEnum.PARAM_ZJ.getCode(), list);
                        getReadyCommitRequest(event, res, BudgetParamEnum.PARAM_ZS.getCode(), list);

                        budgetPlanMapper.insertToReadyCommit(list);
                    });
                }
            }
        } catch (Exception e) {
            budgetPlanMapper.updateStatusById(event.getPlanId(), CommonStatusEnum.REVIEW_XJ.getCode());
            throw new RuntimeException("自动生成代办失败，错误信息：" + e.getStackTrace()[0].toString());
        }

    }

    /**
     * 生成代办信息实体
     * @param event
     * @param res
     * @param type
     * @param list
     */
    private void getReadyCommitRequest(ReadyCommitEvent event, PlanBuildingResponse res,
                                       Integer type, List<ReadyCommitRequest> list) {
        ReadyCommitRequest request = new ReadyCommitRequest();
        request.setReadyCommitId(sid.nextShort());
        request.setPlanId(event.getPlanId());
        request.setStatus(CommonStatusEnum.CSLB_WSZ.getCode());
        BeanUtils.copyProperties(res, request);
        request.setParamType(type);
        list.add(request);
    }
}
