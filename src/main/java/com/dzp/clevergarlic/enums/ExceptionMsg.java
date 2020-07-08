package com.dzp.clevergarlic.enums;

/**
 * 接口返回枚举
 * @Auther ck
 * @Date 2020/7/1 13:25
 * @Desc
 */
public enum ExceptionMsg implements CodeEnum{

    /*通用*/
    SUCCESS(200, "操作成功"),
    FAILED(400, "操作失败"),
    ParamError(401, "参数错误！"),
    FriendTrip(4001,"友情提示"),
    SERVER_ERROR(500, "服务器错误"),

    /*权限登录相关*/
    LOGINOUT(1001, "token失效，请重新登陆！"),
    ACCESS_LIMIT_REACHED(1002, "访问太频繁了！"),
    CAPTCHA_ERROR(1003, "验证码错误"),
    USER_CREATING(1003, "该账户创建中"),
    USER_DOT_ACCESS(1003, "账户已停用"),
    APPINFO_ERROR(1004, "app参数缺少"),
    LOGINPASS_ERROR(1005, "账户或密码错误"),
    USER_DOT_EXIST(1006, "该账号不存在"),
    LOGINPASS_LENGTH_ERROR(1007, "密码为6~18位数字或字母组合"),
    LOGIN_TWO(1008, "您的账号已在其他设备登录"),
    USERPASS_EXIST(1009, "用户密码已存在"),
    USERPASS_OLD_ERROR(1010, "原始密码错误"),
    USERPASS_NEW_ERROR(1011, "新密码不能与旧密码相同"),
    USER_DEVICE_TYPE_EXIST(1012, "用户系统类型已存在"),
    ADMIN_NOT_EXIST(1013, "登录失败,用户不存在或密码错误"),
    ADMIN_CAPTCHA_ERROR(1014, "登录失败,验证码错误"),
    VERIFICATION_CODE_EXPIRE(10031, "验证码已失效"),
    UNDEFINED_ENUM(10032, "未知枚举"),
    PASSWORD_EXPIRED_ERROR(10033, "密码过期，请重置"),
    FAILED_HEADER_PLATFORM(10034, "请求头platform传参错误"),
    UNDEFINED_ROLE(10035, "未知角色"),
    UNDEFINED_INTERVAL_CONDITION(10036, "未知区间条件"),
    UNDEFINED_CONDITION(10037, "未知条件"),
    ;

    private ExceptionMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static ExceptionMsg getCheckTokenException(int code) {
        switch (code) {
            case 10033:
                return PASSWORD_EXPIRED_ERROR;
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
