package com.dzp.clevergarlic.dto.admin.authDTO.response.permission;

import java.util.List;

/**
 * 用户权限data
 * @Auther ck
 * @Date 2020/7/27 14:53
 * @Desc
 */
public class AuthUserData {

    /**
     * 数据权限
     */
    private List<String> authDates;

    /**
     * 权限code集合
     */
    private List<String> authorities;

    /**
     * 用户data
     */
    private AdminUserData user;

    public List<String> getAuthDates() {
        return authDates;
    }

    public void setAuthDates(List<String> authDates) {
        this.authDates = authDates;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    public AdminUserData getUser() {
        return user;
    }

    public void setUser(AdminUserData user) {
        this.user = user;
    }
}
