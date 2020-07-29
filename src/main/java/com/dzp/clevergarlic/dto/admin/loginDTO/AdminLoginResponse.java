package com.dzp.clevergarlic.dto.admin.loginDTO;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/29 9:50
 * @Desc
 */
public class AdminLoginResponse implements Serializable {

    @ApiModelProperty("管理员id")
    private Long id;

    @ApiModelProperty("管理员姓名")
    private String userName;

    @ApiModelProperty("管理员手机号")
    private String phone;

    @ApiModelProperty("用户权限")
    private List<String> authList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getAuthList() {
        return authList;
    }

    public void setAuthList(List<String> authList) {
        this.authList = authList;
    }
}
