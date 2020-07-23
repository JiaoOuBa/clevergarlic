package com.dzp.clevergarlic.web.admin;

import com.dzp.clevergarlic.dto.admin.businessDTO.BusinessInfoResponse;
import com.dzp.clevergarlic.dto.admin.businessDTO.EditBusinessRequest;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.BusinessService;
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
public class BusinessController {

    @Autowired
    BusinessService businessService;


    @ApiOperation(value = "提交/保存为草稿")
    @PostMapping(value = "/editBusiness")
    public ResultVo editBusiness(@RequestBody EditBusinessRequest request) {
        try {
            businessService.editBusiness(request);
            return Result.success("操作成功");
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }

    @ApiOperation(value = "详情")
    @GetMapping(value = "/getBusinessInfo")
    public ResultVo<BusinessInfoResponse> getBusinessInfo(@ApiParam("招商预测参数id") @RequestParam(value = "businessId") String id) {
        try {
            return Result.success(businessService.getBusinessInfo(id));
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }
}
