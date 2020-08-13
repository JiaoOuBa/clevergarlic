package com.dzp.clevergarlic.web.admin.user;

import com.dzp.clevergarlic.config.annotation.PassToken;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginRequest;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.properties.FcCoreProperties;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.admin.AdminPermissionService;
import com.dzp.clevergarlic.util.AESUtil;
import com.dzp.clevergarlic.util.IdUtil.RandomValidateCodeUtil;
import com.dzp.clevergarlic.web.admin.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@Slf4j
@RequestMapping(value = "admin/login", produces = "application/json;charset=utf-8")
public class AdminLoginController extends BaseController {

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
        String type = getLanguageType();

        // 好像不用做解密，直接与数据库对比
        String password = aesUtil.Decrypt(request.getPassword(), AES_KEY);

        try {
            return adminPermissionService.login(request.getUserName(), request.getPassword(), request.getCode());
        } catch (Exception e) {
            return Result.error(ExceptionMsg.ADMIN_NOT_EXIST, type, e);
        }
    }

    @ApiOperation("验证码")
    @PostMapping("v1/verificationCode")
    @ApiImplicitParam(name = "Authorization", access = "hidden")
    @PassToken
    public void verificationCode(HttpServletRequest request,
                                 HttpServletResponse response) {

        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            log.error("获取验证码失败>>>>   ", e);
        }
    }
}
