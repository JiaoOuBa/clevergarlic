package com.dzp.clevergarlic.dto.common.userDTO;

/**
 * @Auther ck
 * @Date 2020/7/9 16:08
 * @Desc
 */
public class User {

    private String userId;
    private String userName;
    private String password;
    private Integer status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
