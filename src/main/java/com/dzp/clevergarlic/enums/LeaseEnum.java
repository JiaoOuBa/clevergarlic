package com.dzp.clevergarlic.enums;

/**
 * 租金参数枚举类
 * @Auther ck
 * @Date 2020/8/4 11:03
 * @Desc
 */
public enum LeaseEnum implements CodeEnum{

    /*设定方式*/
    LEASE_TYPE_DY(1, "按单元"),
    LEASE_TYPE_LC(2, "按楼层"),
    LEASE_TYPE_Zl(3, "按整楼"),

    ;

    private Integer code;

    private String message;

    LeaseEnum(Integer code, String message) {
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

    public static String getType(Integer code) {
        for (LeaseEnum value : LeaseEnum.values()) {
            if (code == null) {
                return null;
            }
            if (value.getCode().equals(code)) {
                return value.getMessage();
            }
        }
        return null;
    }
}
