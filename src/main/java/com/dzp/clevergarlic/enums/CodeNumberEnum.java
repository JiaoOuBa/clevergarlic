package com.dzp.clevergarlic.enums;

/**
 * 单据编号枚举
 * @Auther ck
 * @Date 2020/7/22 18:06
 * @Desc
 */
public enum CodeNumberEnum {

    CODE_YCJH("FP",5,"预测计划"),

    ;
    String prefix;
    Integer length;
    String message;

    CodeNumberEnum(String prefix, Integer length, String message) {
        this.prefix = prefix;
        this.length = length;
        this.message = message;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
