package com.dzp.clevergarlic.dto.admin.authDTO.response.permission;

import io.swagger.annotations.ApiModelProperty;

/**
 * 管理员用户信息
 * @Auther ck
 * @Date 2020/7/27 13:42
 * @Desc
 */
public class AdminUserInfo {

    @ApiModelProperty("管理员id")
    private Long adminId;

    @ApiModelProperty("用户名称")
    private String adminName;

    @ApiModelProperty("用户状态")
    private Integer status;

    @ApiModelProperty("是否有权限")
    private Boolean auth;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }
}
