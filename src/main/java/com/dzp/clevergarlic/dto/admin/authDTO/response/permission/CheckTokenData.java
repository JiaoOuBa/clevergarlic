package com.dzp.clevergarlic.dto.admin.authDTO.response.permission;

/**
 * 校验token接口响应data
 * @Auther ck
 * @Date 2020/7/27 14:51
 * @Desc
 */
public class CheckTokenData {

    private Boolean accessed;

    private AuthUserData user;

    private Long userId;

    public Boolean getAccessed() {
        return accessed;
    }

    public void setAccessed(Boolean accessed) {
        this.accessed = accessed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public AuthUserData getUser() {
        return user;
    }

    public void setUser(AuthUserData user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CheckTokenData{" +
                "accessed=" + accessed +
                ", user=" + user +
                ", userId=" + userId +
                '}';
    }
}
