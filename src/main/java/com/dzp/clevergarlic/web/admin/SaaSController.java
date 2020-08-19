package com.dzp.clevergarlic.web.admin;

import com.dzp.clevergarlic.dao.SaaSRepository;
import com.dzp.clevergarlic.dto.admin.SaaSDTO.CreateRequest;
import com.dzp.clevergarlic.entity.SaaSEntity;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.admin.SaaSService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * SaaS管理
 * @Auther ck
 * @Date 2020/8/17 17:09
 * @Desc
 */

@Api(value = "saaS", description = "SaaS公司管理相关接口（ck）")
@RestController
@RequestMapping(value = "saaS", produces = "application/json;charset=utf-8")
public class SaaSController extends BaseController {

    @Autowired
    SaaSService saaSService;

    @Autowired
    SaaSRepository saaSRepository;

    // 拿到dPro过来的公司数据
    // 后台开公司（创建公司）
    // 1.dPro数据作为供选择项，拿到SaaSId,OrgId创建新公司; 2.新建forecast公司

    @ApiOperation(value = "创建公司")
    @PostMapping(value = "/v1/createCompany")
    public ResultVo createCompany(@Valid @RequestBody CreateRequest createRequest) {
        String type = getLanguageType();
        try {
            return saaSService.createCompany(createRequest);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

    @ApiOperation(value = "dPro公司列表")
    @GetMapping(value = "/getDProCompany")
    public ResultVo getDProCompany() {
        String type = getLanguageType();
        try {
            List<SaaSEntity> all = saaSRepository.findAll();
            return Result.success(ExceptionMsg.SUCCESS,all,type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }
}
