package com.dzp.clevergarlic.dto.common.user;

/**
 * @Auther ck
 * @Date 2020/7/9 16:48
 * @Desc
 */
public class LoginRequest {

    private String userName;
    private String password;

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
}
