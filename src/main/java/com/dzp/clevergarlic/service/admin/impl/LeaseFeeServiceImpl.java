package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.config.UserContext;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.ConfirmRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.DelLeaseFeeRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request.EditLeaseFeeRequest;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeForm;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeaseFeeInfoResponse;
import com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response.LeasePrice;
import com.dzp.clevergarlic.enums.CommonEnum;
import com.dzp.clevergarlic.enums.CommonStatusEnum;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.enums.LeaseEnum;
import com.dzp.clevergarlic.mapper.admin.LeaseFeeMapper;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.admin.LeaseFeeService;
import com.dzp.clevergarlic.util.DateUtil;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

/**
 * 租金预测参数
 * @Auther ck
 * @Date 2020/7/13 13:13
 * @Desc
 */
@Service
public class LeaseFeeServiceImpl implements LeaseFeeService {

    @Autowired
    Sid sid;

    @Autowired
    LeaseFeeMapper leaseFeeMapper;

    /**
     * 保存数据
     * @param request
     */
    @Override
    public void editLeaseFee(EditLeaseFeeRequest request) {

        request.setVersion("v" + DateUtil.getDateTime());

        List<String> leaseIds = leaseFeeMapper.countLeaseByPlan(request.getPlanId(), CommonEnum.IS_DELETED_NOT.getCode());
        if (leaseIds.size() > 0) {
            leaseIds.forEach(res -> {
                // 删除子表-租金单价
                leaseFeeMapper.deleteLeasePrice(res);
            });
            // 删除主表
            leaseFeeMapper.deleteLeaseFee(leaseIds);
        }

        List<LeaseFeeForm> leaseFeeForms = request.getLeaseFeeForms();
        for (LeaseFeeForm form : leaseFeeForms) {

            // 数据校验
            checkParameters(form);
            // 插入主表
            insertToMain(request, form);
            // 插入租金单价信息
            insertToChild(form);
        }

    }

    private void insertToMain(EditLeaseFeeRequest request, LeaseFeeForm form) {
        String leaseId = sid.nextShort();
        form.setLeaseId(leaseId);
        form.setPlanId(request.getPlanId());
        form.setStatus(CommonStatusEnum.REVIEW_XJ.getCode());
        form.setVersion(request.getVersion());


        leaseFeeMapper.insertLeaseFee(form);
    }

    private void insertToChild(LeaseFeeForm form) {
        if (CollectionUtils.isNotEmpty(form.getPriceList())) {
            for (LeasePrice price : form.getPriceList()) {
                price.setLpyId(sid.nextShort());
                price.setLeaseId(form.getLeaseId());
                // 插入子表-租金单价
                leaseFeeMapper.insertLeasePrice(price);
            }
        }
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @Override
    public LeaseFeeInfoResponse getLeaseFeeInfo(String id) {

        LeaseFeeInfoResponse info = leaseFeeMapper.getLeaseFeeInfo(id);
        info.setAdminName("todo");
        info.setReviewAdminName("todo");
        return info;
    }

    /**
     * 删除
     * @param request
     */
    @Override
    public void deleteLeaseFee(DelLeaseFeeRequest request) {

        // TODO: 2020/7/21 状态判断

        leaseFeeMapper.deleteLeaseFee(request.getIds());
    }

    /**
     * 确认/反确认
     * @param request
     * @return
     */
    @Override
    public ResultVo confirm(ConfirmRequest request) {

        if (request.getType() == 1) {

            // TODO: 2020/8/3 此时确认单栋楼参数还是所有楼（该计划内）参数 ?
        }
        return Result.success(ExceptionMsg.SUCCESS, UserContext.getLanguageType().get());
    }

    private void checkParameters(LeaseFeeForm form) {

        if (LeaseEnum.LEASE_TYPE_Zl.getCode().equals(form.getInstallType())) {
            Assert.notNull(form.getInstallValue(),"按整楼参数：设定值不能为空");
            Assert.notEmpty(form.getPriceList(),"按整楼参数：租金单价不能为空");
        }
    }
}
