package com.dzp.clevergarlic.enums;

/**
 * @Auther ck
 * @Date 2020/7/9 16:13
 * @Desc
 */
public enum UserEnum implements CodeEnum {

    // 用户状态
    USER_JH(1,"激活"),
    USER_DJ(0,"冻结"),
    ;

    private UserEnum(Integer code, String msg) {
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
        return null;
    }

    public String getMsgByCode(Integer code) {
        for (UserEnum value : UserEnum.values()) {
            if (code == null) {
                return null;
            }
            if (value.getCode().equals(code)) {
                return value.getMsg();
            }
        }
        return null;
    }
}
