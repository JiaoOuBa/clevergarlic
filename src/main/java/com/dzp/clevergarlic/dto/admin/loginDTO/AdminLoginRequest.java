package com.dzp.clevergarlic.dto.admin.loginDTO;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * 登陆请求
 * @Auther ck
 * @Date 2020/7/28 15:39
 * @Desc
 */
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static AdminLoginRequest of(String userName,String password, String time) {
        AdminLoginRequest request = new AdminLoginRequest();
        request.setUserName(userName);
        request.setPassword(password);
        request.setTime(time);
        return request;
    }

    @Override
    public String toString() {
        return "AdminLoginRequest{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
