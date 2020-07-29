package com.dzp.clevergarlic.dto.admin.authDTO.response.permission;

/**
 * @Auther ck
 * @Date 2020/7/29 11:13
 * @Desc
 */
public class TokenInfoResponse {

    private Long adminId;
    private String userName;
    private String tokenStr;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }


    public static TokenInfoResponse of(Long adminId,String userName,String tokenStr) {
        TokenInfoResponse info = new TokenInfoResponse();
        info.setAdminId(adminId);
        info.setUserName(userName);
        info.setTokenStr(tokenStr);
        return info;
    }
}
