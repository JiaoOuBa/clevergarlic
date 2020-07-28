package com.dzp.clevergarlic.properties;

import com.dzp.clevergarlic.enums.Environment;

/**
 * 权限配置
 * @Auther ck
 * @Date 2020/7/27 14:26
 * @Desc
 */
public class AuthProperties {

    private Boolean openToken;

    private Integer expired = 7200;// 过期秒数

    private String hostUrl;

    private String loginUrl;

    private String authUrl;

    private String adminInfo;

    private String changeUserPasswordUrl;

    private String userListUrl;

    private Environment env;

    public String getUserListUrl() {
        return userListUrl;
    }

    public void setUserListUrl(String userListUrl) {
        this.userListUrl = userListUrl;
    }

    public String getChangeUserPasswordUrl() {
        return changeUserPasswordUrl;
    }

    public void setChangeUserPasswordUrl(String changeUserPasswordUrl) {
        this.changeUserPasswordUrl = changeUserPasswordUrl;
    }

    public Environment getEnv() {
        return env;
    }

    public void setEnv(Environment env) {
        this.env = env;
    }

    public Boolean getOpenToken() {
        return openToken;
    }

    public void setOpenToken(Boolean openToken) {
        this.openToken = openToken;
    }

    public Integer getExpired() {
        return expired;
    }

    public void setExpired(Integer expired) {
        this.expired = expired;
    }

    public String getHostUrl() {
        return hostUrl;
    }

    public void setHostUrl(String hostUrl) {
        this.hostUrl = hostUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

    public String getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(String adminInfo) {
        this.adminInfo = adminInfo;
    }
}
