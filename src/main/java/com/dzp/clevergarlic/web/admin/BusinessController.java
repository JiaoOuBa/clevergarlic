package com.dzp.clevergarlic.web.admin;

import com.dzp.clevergarlic.dto.admin.businessDTO.BusinessInfoResponse;
import com.dzp.clevergarlic.dto.admin.businessDTO.EditBusinessRequest;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.admin.BusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 招商预测参数信息controller
 * @Auther ck
 * @Date 2020/7/13 16:57
 * @Desc
 */

@Api(value = "business", description = "招商预测参数信息相关接口（ck）")
@RestController
@RequestMapping(value = "business", produces = "application/json;charset=utf-8")
public class BusinessController extends BaseController{

    @Autowired
    BusinessService businessService;


    @ApiOperation(value = "提交/保存为草稿")
    @PostMapping(value = "/v1/editBusiness")
    public ResultVo editBusiness(@RequestBody EditBusinessRequest request) {
        String type = getLanguageType();
        try {

            return businessService.editBusiness(request, type);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

    @ApiOperation(value = "详情")
    @GetMapping(value = "/v1/getBusinessInfo")
    public ResultVo<BusinessInfoResponse> getBusinessInfo(@ApiParam("楼宇id") @RequestParam(value = "buildingId") String buildingId) {
        String type = getLanguageType();
        try {
            return businessService.getBusinessInfo(buildingId);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }
}
