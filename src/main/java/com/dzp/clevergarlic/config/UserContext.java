package com.dzp.clevergarlic.config;

import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.AdminUserInfo;

/**
 * 当前线程的用户id的get、set
 * @Auther ck
 * @Date 2020/7/27 13:59
 * @Desc
 */
public class UserContext {

    private static ThreadLocal<String> userHolder = new ThreadLocal<String>();
    private static ThreadLocal<String> userToken = new ThreadLocal<>();
    private static ThreadLocal<String> adminUserToken = new ThreadLocal<>();
    private static ThreadLocal<String> usertraceId = new ThreadLocal<>();
    private static ThreadLocal<String> languageType = new ThreadLocal<>();
    private static ThreadLocal<AdminUserInfo> adminUserInfo = new ThreadLocal<>();

    public static void setAdminId(String adminId) {
        userHolder.set(adminId);
    }

    public static String getAdminId() {
        return userHolder.get();
    }

    public static ThreadLocal<String> getUserToken() {
        return userToken;
    }

    public static void setUserToken(ThreadLocal<String> userToken) {
        UserContext.userToken = userToken;
    }

    public static ThreadLocal<String> getAdminUserToken() {
        return adminUserToken;
    }

    public static void setAdminUserToken(ThreadLocal<String> adminUserToken) {
        UserContext.adminUserToken = adminUserToken;
    }

    public static String getUserTraceId() {
        return usertraceId.get();
    }

    public static void setUserTraceId(String traceId) {
        usertraceId.set(traceId);
    }

    public static ThreadLocal<AdminUserInfo> getAdminUserInfo() {
        return adminUserInfo;
    }

    public static void setAdminUserInfo(ThreadLocal<AdminUserInfo> adminUserInfo) {
        UserContext.adminUserInfo = adminUserInfo;
    }

    public static ThreadLocal<String> getLanguageType() {
        return languageType;
    }

    public static void setLanguageType(ThreadLocal<String> languageType) {
        UserContext.languageType = languageType;
    }

    public static void removeUserTraceId() {
        usertraceId.remove();
    }

    public static void removeAdminId() {
        userHolder.remove();
    }
}
