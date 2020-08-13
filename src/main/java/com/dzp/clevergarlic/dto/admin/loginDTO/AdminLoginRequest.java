package com.dzp.clevergarlic.dto.admin.loginDTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 登陆请求
 * @Auther ck
 * @Date 2020/7/28 15:39
 * @Desc
 */
@Data
public class AdminLoginRequest {

    @ApiModelProperty(value = "用户名")
    @NotEmpty(message = "密码不能为空")
    private String userName;

    @ApiModelProperty(value = "密码")
    @NotEmpty(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "时间戳")
    @NotEmpty(message = "时间戳不能为空")
    private String time;

    @ApiModelProperty(value = "验证码")
    @NotEmpty(message = "验证码不能为空")
    private String code;

}
