package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.dto.admin.businessDTO.BusinessInfoResponse;
import com.dzp.clevergarlic.dto.admin.businessDTO.EditBusinessRequest;
import com.dzp.clevergarlic.dto.admin.businessDTO.response.BusinessForm;
import com.dzp.clevergarlic.enums.CommonEnum;
import com.dzp.clevergarlic.enums.CommonStatusEnum;
import com.dzp.clevergarlic.mapper.admin.BusinessMapper;
import com.dzp.clevergarlic.service.admin.BusinessService;
import com.dzp.clevergarlic.util.DateUtil;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 招商预测参数
 * @Auther ck
 * @Date 2020/7/13 17:02
 * @Desc
 */

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    Sid sid;

    @Autowired
    BusinessMapper businessMapper;

    /**
     * 保存数据
     * @param request
     */
    @Override
    public void editBusiness(EditBusinessRequest request) {

        request.setVersion("v" + DateUtil.getDateTime());

        Integer countBusiness = businessMapper.countBusinessByPlan(request.getPlanId(), CommonEnum.IS_DELETED_NOT.getCode());
        if (countBusiness > 0) {
            // 删除plan对应的招商参数
            businessMapper.deleteBusinessByPlan(request.getPlanId(), CommonEnum.IS_DELETED_YES.getCode());
        }

        List<BusinessForm> businessForms = request.getBusinessForms();
        for (BusinessForm form : businessForms) {

            // 数据校验
            checkParameters(form);

            String businessId = sid.nextShort();
            form.setBusinessId(businessId);
            form.setPlanId(request.getPlanId());
            form.setVersion(request.getVersion());
            form.setStatus(CommonStatusEnum.REVIEW_WQR.getCode());
            // 插入招商参数
            businessMapper.insertBusiness(form);
        }

    }

    /**
     * 详情
     * @param planId  计划id
     * @return
     */
    @Override
    public BusinessInfoResponse getBusinessInfo(String planId) {

        BusinessInfoResponse info = new BusinessInfoResponse();
        List<BusinessForm> businessForms = businessMapper.getBusinessByPlan(planId);
        Assert.notEmpty(businessForms);

        info.setPlanId(planId);
        info.setAdminId(businessForms.get(0).getAdminId());
        return info;
    }


    private void checkParameters(BusinessForm form) {

    }
}
