package com.dzp.clevergarlic.dto.admin.loginDTO;

import io.swagger.annotations.ApiModelProperty;

/**
 * 管理员token对象
 *
 * @Auther ck
 * @Date 2020/7/29 9:49
 * @Desc
 */
public class AdminToken {

    @ApiModelProperty("管理员信息")
    private AdminLoginResponse adminLoginResponse;

    @ApiModelProperty("管理员token")
    private String adminToken;

    @ApiModelProperty("token插入时间")
    private String insertTime;

    public AdminLoginResponse getAdminLoginResponse() {
        return adminLoginResponse;
    }

    public void setAdminLoginResponse(AdminLoginResponse adminLoginResponse) {
        this.adminLoginResponse = adminLoginResponse;
    }

    public String getAdminToken() {
        return adminToken;
    }

    public void setAdminToken(String adminToken) {
        this.adminToken = adminToken;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }
}
