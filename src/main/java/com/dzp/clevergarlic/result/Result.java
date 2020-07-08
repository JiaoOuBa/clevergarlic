package com.dzp.clevergarlic.result;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回信息封装
 * @Auther ck
 * @Date 2020/7/1 13:35
 * @Desc
 */
public class Result {

    public static <T> ResultVo<T> success(T object, String msg) {
        ResultVo<T> resultVo = new ResultVo<>(ExceptionMsg.SUCCESS, msg, object);
        return resultVo;
    }

    public static ResultVo success(Object object, List<String> msg) {
        ResultVo resultVo = new ResultVo(ExceptionMsg.SUCCESS, msg, object);
        return resultVo;
    }

    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo(object);
        return resultVo;
    }

    public static ResultVo success() {
        ResultVo resultVo = new ResultVo();
        resultVo.setData(1);
        return resultVo;
    }

    public static ResultVo error(ExceptionMsg code, List<String> msg) {
        ResultVo resultVo = new ResultVo(code, msg, null);
        LogUtil.info("流程错误", msg.toString());
        return resultVo;
    }

    public static ResultVo error(int code, List<String> msg) {
        ResultVo resultVo = new ResultVo(code, msg, null);
        LogUtil.info("流程错误", msg.toString());
        return resultVo;
    }

    public static ResultVo error(ExceptionMsg code, String msg) {
        ResultVo resultVo = new ResultVo(code, msg, null);
        LogUtil.info("流程错误", msg);
        return resultVo;
    }

    public static ResultVo error(ExceptionMsg code) {
        ResultVo resultVo = new ResultVo(code, null);
        LogUtil.info("流程错误", code.getMsg());
        return resultVo;
    }

    public static ResultVo error(ExceptionMsg code, Throwable e) {
        List<String> msgList = new ArrayList<>();
        msgList.add(e.getMessage());
        ResultVo resultVo = new ResultVo(code, msgList,null);
        StackTraceElement stackTrace = e.getStackTrace()[0];
        resultVo.setErrorMsg("文件名：" + stackTrace.getFileName()+"行："+stackTrace.getLineNumber());
        LogUtil.info("流程错误", code.getMsg());
        return resultVo;
    }
}
