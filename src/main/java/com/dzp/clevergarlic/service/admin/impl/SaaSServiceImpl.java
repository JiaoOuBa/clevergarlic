package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.config.UserContext;
import com.dzp.clevergarlic.dao.CompanyRepository;
import com.dzp.clevergarlic.dao.UserRepository;
import com.dzp.clevergarlic.dto.RegionDTO.CheckRegionRequest;
import com.dzp.clevergarlic.dto.RegionDTO.CheckRegionResponse;
import com.dzp.clevergarlic.dto.admin.SaaSDTO.CreateRequest;
import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.AdminUserInfo;
import com.dzp.clevergarlic.dto.admin.shiroDTO.AddUser;
import com.dzp.clevergarlic.entity.CompanyEntity;
import com.dzp.clevergarlic.entity.shiro.User;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.admin.CommonService;
import com.dzp.clevergarlic.service.admin.SaaSService;
import com.dzp.clevergarlic.service.shiro.ShiroService;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auther ck
 * @Date 2020/8/18 11:25
 * @Desc
 */
@Service
public class SaaSServiceImpl implements SaaSService {

    private final String initialPassword = "123456";

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    ShiroService shiroService;

    @Autowired
    Sid sid;

    @Autowired
    CommonService commonService;


    /**
     * 创建SaaS公司
     * @param createRequest
     * @return
     */
    @Override
    public ResultVo createCompany(CreateRequest createRequest) {
        AdminUserInfo adminUserInfo = UserContext.getAdminUserInfo().get();

        // 创建saas用户
        Long userId = createSaaSUser(createRequest);
        createRequest.setUserId(userId);

        // 创建saas公司
        createCompanyEntity(createRequest, adminUserInfo);

        return Result.success(ExceptionMsg.SUCCESS, UserContext.getLanguageType().get());
    }

    private void createCompanyEntity(CreateRequest createRequest, AdminUserInfo adminUserInfo) {

        createRequest.setAdminId(adminUserInfo.getAdminId());
        // 省市区转换成id
        CheckRegionRequest request = new CheckRegionRequest();
        BeanUtils.copyProperties(createRequest, request);
        ResultVo<CheckRegionResponse> checkRegionResponseResultVo = commonService.checkRegion(request);
        CheckRegionResponse data = checkRegionResponseResultVo.getData();
        if (data != null) {
            createRequest.setProvinceId(data.getProvinceId());
            createRequest.setCityId(data.getCityId());
            createRequest.setAreaId(data.getAreaId());
        }

        CompanyEntity companyEntity = new CompanyEntity();
        BeanUtils.copyProperties(createRequest, companyEntity);
        companyEntity.setCompanyId(sid.nextShort());

        companyRepository.save(companyEntity);
    }

    private Long createSaaSUser(CreateRequest createRequest) {

        AddUser user = new AddUser();
        user.setUserName(createRequest.getUserEnName());
        user.setPassword(initialPassword);
        shiroService.addUser(user);

        User getUser = userRepository.findByUserName(createRequest.getUserEnName());
        if (getUser != null) {
            return getUser.getNewUserId();
        } else {
            throw new RuntimeException("创建SaaS用户失败");
        }
    }
}
