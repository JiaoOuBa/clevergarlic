package com.dzp.clevergarlic.web.admin;

import com.dzp.clevergarlic.dto.admin.businessDto.EditBusinessRequest;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.BusinessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
