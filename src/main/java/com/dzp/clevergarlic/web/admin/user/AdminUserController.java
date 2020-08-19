package com.dzp.clevergarlic.web.admin.user;

import com.dzp.clevergarlic.dto.admin.shiroDTO.AddUser;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.shiro.ShiroService;
import com.dzp.clevergarlic.web.admin.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Auther ck
 * @Date 2020/8/18 13:40
 * @Desc
 */

@Api(value = "adminUser", description = "后台用户-相关接口（ck）")
@RestController
@Slf4j
@RequestMapping(value = "adminUser", produces = "application/json;charset=utf-8")
public class AdminUserController extends BaseController {

    @Autowired
    ShiroService shiroService;

    @ApiOperation(value = "新增用户")
    @PostMapping(value = "/addUser")
    public ResultVo addUser(@Valid @RequestBody AddUser addUser) {
        String type = getLanguageType();
        try {
            return shiroService.addUser(addUser);
        } catch (Exception e) {
            return Result.error(ExceptionMsg.FAILED, type, e);
        }
    }

    /*@ApiOperation(value = "新增角色")
    @PostMapping(value = "/addRole")
    public ResultVo addRole(@Valid @RequestBody) {}*/
}
