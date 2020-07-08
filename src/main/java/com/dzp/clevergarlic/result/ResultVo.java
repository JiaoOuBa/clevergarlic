package com.dzp.clevergarlic.result;

import com.dzp.clevergarlic.enums.ExceptionMsg;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回信息封装
 * @Auther ck
 * @Date 2020/7/1 13:33
 * @Desc
 */
public class ResultVo<T> {

    @ApiModelProperty(value = "返回状态码")
    private Integer code = 200;

    @ApiModelProperty(value = "提示信息列表")
    private List<String> msg = new ArrayList<>();

    private String errorMsg;

    @ApiModelProperty(value = "返回结果")
    private T data;

    public ResultVo() {
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(ExceptionMsg.SUCCESS.getMsg());
        this.setMsg(msgList);
    }

    public ResultVo(T data) {
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(ExceptionMsg.SUCCESS.getMsg());
        this.setData(data);
    }

    public ResultVo(ExceptionMsg msg, String rspMsg, T data) {
        this.setCode(msg.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(rspMsg);
        this.setMsg(msgList);
        this.setData(data);
    }

    public ResultVo(ExceptionMsg msg, List<String> rspMsg, T data) {
        this.setCode(msg.getCode());
        this.setMsg(rspMsg);
        this.setData(data);
    }

    public ResultVo(int code, List<String> rspMsg, T data) {
        this.setCode(code);
        this.setMsg(rspMsg);
        this.setData(data);
    }

    public ResultVo(ExceptionMsg msg, T data) {
        this.setCode(msg.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(msg.getMsg());
        this.setMsg(msgList);
        this.setData(data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "code=" + code +
                ", msg=" + msg +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
