package com.dzp.clevergarlic.web.common;

import com.dzp.clevergarlic.config.annotation.PassToken;
import com.dzp.clevergarlic.dto.common.ExecuteSqlRequest;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.service.CommonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础数据
 * @Auther ck
 * @Date 2020/7/3 17:43
 * @Desc
 */
@Api(value = "BasicData", description = "公共数据模块接口")
@RestController
@RequestMapping(value = "/basic", produces = "application/json;charset=utf-8")
public class BasicDataController {

    @Autowired
    CommonService commonService;

    @ApiOperation(value = "execute SQL script")
    @PostMapping(value = "executeSql")
    @PassToken
    public Object executeSql(@RequestBody ExecuteSqlRequest request) {
        try {
            List<String> msg = new ArrayList<>();
            msg.add("execute sql success !");
            return Result.success(commonService.executeSql(request), msg);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, e.getMessage());
        }
    }
}
