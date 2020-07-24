package com.dzp.clevergarlic.service.impl;

import com.dzp.clevergarlic.dto.admin.businessDTO.BusinessInfoResponse;
import com.dzp.clevergarlic.dto.admin.businessDTO.EditBusinessRequest;
import com.dzp.clevergarlic.enums.CommonStatusEnum;
import com.dzp.clevergarlic.mapper.admin.BusinessMapper;
import com.dzp.clevergarlic.service.BusinessService;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (request.getOperation() == null) {
            throw new RuntimeException("操作类型必传");
        }
        if (request.getOperation() == 1) {
            request.setStatus(CommonStatusEnum.REVIEW_WQR.getCode());
        } else {
            request.setStatus(CommonStatusEnum.REVIEW_WQR.getCode());
        }

        // 数据校验
        checkParameters(request);

        if (ObjectUtils.isEmpty(request.getBusinessId())) {// 新增

            request.setBusinessId(sid.nextShort());
            // do insert

        } else {// 修改
            // do update

        }
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @Override
    public BusinessInfoResponse getBusinessInfo(String id) {

        BusinessInfoResponse info = null;
        return null;
    }


    private void checkParameters(EditBusinessRequest request) {

    }
}
