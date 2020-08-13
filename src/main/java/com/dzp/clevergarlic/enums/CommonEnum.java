package com.dzp.clevergarlic.enums;

/**
 * 公共枚举类
 * @Auther ck
 * @Date 2020/8/4 10:21
 * @Desc
 */
public enum CommonEnum implements CodeEnum {

    /*  删除标识*/
    IS_DELETED_YES(1, "已删除"),
    IS_DELETED_NOT(0, "未删除"),

    /* 语言类型 */
    LANGUAGE_CN(1,"zh-CN"),// 中文
    LANGUAGE_EN(2,"en-US"),// 英文

    ;

    private Integer code;

    private String message;

    CommonEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
