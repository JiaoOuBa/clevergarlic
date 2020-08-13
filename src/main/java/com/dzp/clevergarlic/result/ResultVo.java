package com.dzp.clevergarlic.result;

import com.dzp.clevergarlic.enums.CommonEnum;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.util.LanguageUtil;
import io.swagger.annotations.ApiModelProperty;

import java.util.*;

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

    public ResultVo(String msgType) {
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(typeGetMsg(ExceptionMsg.SUCCESS, msgType));
        this.setMsg(msgList);
    }

    public ResultVo(ExceptionMsg msg,String msgType) {
        this.setCode(msg.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(typeGetMsg(msg, msgType));
        this.setMsg(msgList);
    }

    public ResultVo(T data, String msgType) {
        this.setCode(ExceptionMsg.SUCCESS.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(typeGetMsg(ExceptionMsg.SUCCESS, msgType));
        this.setMsg(msgList);
        this.setData(data);
    }

    public ResultVo(ExceptionMsg msg, String rspMsg, String msgType, T data) {
        this.setCode(msg.getCode());
        List<String> msgList = new ArrayList<>(Objects.requireNonNull(LanguageUtil.getMsg(msgType, Collections.singletonList(rspMsg))));
        this.setMsg(msgList);
        this.setData(data);
    }

    public ResultVo(ExceptionMsg msg, List<String> rspMsg, String msgType, T data) {
        this.setCode(msg.getCode());
        this.setMsg(LanguageUtil.getMsg(msgType, rspMsg));
        this.setData(data);
    }

    public ResultVo(ExceptionMsg msg, List<String> excMsg) {
        this.setCode(msg.getCode());
        this.setMsg(excMsg);
    }

    public ResultVo(int code, List<String> rspMsg, String msgType, T data)  {
        this.setCode(code);
        this.setMsg(LanguageUtil.getMsg(msgType, rspMsg));
        this.setData(data);
    }

    public ResultVo(ExceptionMsg msg, String msgType, T data) {
        this.setCode(msg.getCode());
        List<String> msgList = new ArrayList<>();
        msgList.add(typeGetMsg(msg, msgType));
        this.setMsg(msgList);
        this.setData(data);
    }

    public String typeGetMsg(ExceptionMsg exc, String msgType) {
        if (CommonEnum.LANGUAGE_CN.getMessage().equals(msgType)) {
            return exc.getMsg();
        } else if (CommonEnum.LANGUAGE_EN.getMessage().equals(msgType)) {
            return exc.getEnMsg();
        }
        return null;
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
