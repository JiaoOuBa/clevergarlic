package com.dzp.clevergarlic.dto.common;

import java.util.List;

/**
 * http公共response
 * @Auther ck
 * @Date 2020/7/27 14:47
 * @Desc
 */
public class CommonResponse {

    private Integer code;

    private List<String> message;

    private Boolean success;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
