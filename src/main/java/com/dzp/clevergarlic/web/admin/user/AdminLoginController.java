package com.dzp.clevergarlic.web.admin.user;

import com.dzp.clevergarlic.config.annotation.PassToken;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginRequest;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.properties.FcCoreProperties;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.AdminPermissionService;
import com.dzp.clevergarlic.util.AESUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

/**
 * 后台用户登陆
 * @Auther ck
 * @Date 2020/7/28 15:23
 * @Desc
 */
@Api(value = "adminLogin", description = "后台登录-相关接口（ck）")
@RestController
@RequestMapping(value = "admin/login", produces = "application/json;charset=utf-8")
public class AdminLoginController {

    @Value("${fc.aes.key}")
    private String AES_KEY;

    @Autowired
    FcCoreProperties fcCoreProperties;
    @Autowired
    AESUtil aesUtil;
    @Autowired
    AdminPermissionService adminPermissionService;


    @ApiOperation(value = "后台登录")
    @PostMapping("v1")
    @ApiImplicitParam(name = "Authorization", access = "hidden")
    @PassToken
    public ResultVo<Map<String, Object>> login(@Valid @RequestBody AdminLoginRequest request) {

        // 好像不用做解密，直接与数据库对比
        String password = aesUtil.Decrypt(request.getPassword(), AES_KEY);

        try {
            return adminPermissionService.login(request.getUserName(), request.getPassword());
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED,e.getMessage());
        }
    }
}
