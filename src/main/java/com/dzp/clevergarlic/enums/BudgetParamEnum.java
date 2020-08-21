package com.dzp.clevergarlic.enums;

/**
 * 预测参数枚举类
 * @Auther ck
 * @Date 2020/7/23 14:54
 * @Desc
 */
public enum BudgetParamEnum implements CodeEnum{
    PARAM_ZJ(1,"租金趋势预测"),
    PARAM_ZS(2,"招商参数设置"),

    PARAMS_TYPE_DY(1,"按单元"),
    PARAMS_TYPE_LC(2,"按楼层"),
    PARAMS_TYPE_ZD(3,"按整栋"),
    ;


    private BudgetParamEnum(Integer code, String msg) {
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

    public static String getMsgByCode(Integer code) {
        for (BudgetParamEnum value : BudgetParamEnum.values()) {
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
