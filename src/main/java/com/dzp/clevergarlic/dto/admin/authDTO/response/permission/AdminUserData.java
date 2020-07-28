package com.dzp.clevergarlic.dto.admin.authDTO.response.permission;

/**
 * 后台用户data
 * @Auther ck
 * @Date 2020/7/27 14:54
 * @Desc
 */
public class AdminUserData {

    /**
     * userId
     */
    private Long userId;

    /**
     * 用户名
     */
    private String userName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
