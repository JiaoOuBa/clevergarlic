package com.dzp.clevergarlic.enums;

/**
 * 接口返回枚举
 * @Auther ck
 * @Date 2020/7/1 13:25
 * @Desc
 */
public enum ExceptionMsg implements CodeEnum{

    /*通用*/
    SUCCESS(200, "操作成功","Operate Success"),
    FAILED(400, "操作失败","Operate Default"),
    ParamError(401, "参数错误！","Params Error"),
    FriendTrip(4001,"友情提示","Friendly Tips"),
    SERVER_ERROR(500, "服务器错误","Server Error"),

    /*权限登录相关*/
    LOGINOUT(1001, "token失效，请重新登陆！","Token Invalid"),
    ACCESS_LIMIT_REACHED(1002, "访问太频繁了！","Visits Too Frequent"),
    CAPTCHA_ERROR(1003, "验证码错误","Verification Code Error"),
    LOGINPASS_ERROR(1004, "用户名或密码错误","Username Or Password Error"),
    USER_DOT_EXIST(1005, "该账号不存在","User Non-existent"),
    ADMIN_NOT_EXIST(1006, "登录失败,用户不存在或密码错误","Login Default,Username Or Password Error"),
    ADMIN_CAPTCHA_ERROR(1007, "登录失败,验证码错误","Login Default,Verification Code Error"),
    VERIFICATION_CODE_EXPIRE(1008, "验证码已失效","Verification Code Invalid"),
    UNDEFINED_ENUM(1009, "未知枚举","Unknown Enums"),
    FAILED_HEADER_PLATFORM(1010, "请求头platform传参错误","Params Platform Error"),
    UNDEFINED_ROLE(1011, "未知角色","Unknown Roles"),
    UNDEFINED_CONDITION(1012, "未知条件","Unknown Condition"),
    ;

    private ExceptionMsg(Integer code, String msg, String enMsg) {
        this.code = code;
        this.msg = msg;
        this.enMsg = enMsg;
    }

    private Integer code;
    private String msg;
    private String enMsg;

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getEnMsg() {
        return enMsg;
    }

    public static ExceptionMsg getCheckTokenException(int code) {
        switch (code) {

            default:
                return LOGINOUT;
        }
    }

    @Override
    public String toString() {
        return "ExceptionMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
