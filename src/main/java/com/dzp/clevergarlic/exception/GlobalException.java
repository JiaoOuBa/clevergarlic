package com.dzp.clevergarlic.exception;

import com.dzp.clevergarlic.enums.ExceptionMsg;

/**
 * 全局异常
 * @Auther ck
 * @Date 2020/7/2 11:10
 * @Desc
 */
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    private ExceptionMsg em;


    public GlobalException(ExceptionMsg exceptionMsg) {
        super(exceptionMsg.toString());


        this.em = exceptionMsg;
    }


    public ExceptionMsg getEm() {
        return em;
    }
}
