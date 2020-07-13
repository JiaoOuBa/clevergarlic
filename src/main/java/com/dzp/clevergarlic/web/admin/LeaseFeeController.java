package com.dzp.clevergarlic.web.admin;

import com.dzp.clevergarlic.dto.admin.leaseFeeDto.EditLeaseFeeRequest;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.LeaseFeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 租金预测参数信息controller
 * @Auther ck
 * @Date 2020/7/13 11:19
 * @Desc
 */
@Api(value = "leaseFee", description = "租金预测参数信息相关接口（ck）")
@RestController
@RequestMapping(value = "LeaseFee", produces = "application/json;charset=utf-8")
public class LeaseFeeController {

    @Autowired
    LeaseFeeService leaseFeeService;


    @ApiOperation(value = "提交/保存为草稿")
    @PostMapping(value = "/editLeaseFee")
    public ResultVo editLeaseFee(@RequestBody EditLeaseFeeRequest request) {
        try {
            leaseFeeService.editLeaseFee(request);
            return Result.success("操作成功");
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e);
        }
    }
}
