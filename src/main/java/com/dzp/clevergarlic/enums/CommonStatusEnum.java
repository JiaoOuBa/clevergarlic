package com.dzp.clevergarlic.enums;

/**
 * 公共状态枚举
 * @Auther ck
 * @Date 2020/7/13 14:38
 * @Desc
 */
public enum CommonStatusEnum implements CodeEnum {
    REVIEW_CGX(1,"草稿箱"),
    REVIEW_SHZ(2,"审核中"),
    REVIEW_YTG(3,"已通过"),
    ;

    private CommonStatusEnum(Integer code, String msg) {
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
