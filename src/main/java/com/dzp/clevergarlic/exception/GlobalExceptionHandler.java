package com.dzp.clevergarlic.exception;

import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.util.LogUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理类
 * @Auther ck
 * @Date 2020/7/2 11:11
 * @Desc 用于全局返回json，如需返回ModelAndView请使用@ControllerAdvice
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(handlerException(ex), HttpStatus.OK);
    }


    /**
     * 进入控制器后的异常捕获
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVo handlerException(Exception e) {

        e.printStackTrace();
        ResultVo restResult = new ResultVo();

        if (e instanceof MaxUploadSizeExceededException) {
            restResult.setCode(ExceptionMsg.FAILED.getCode());
            List<String> msg = new ArrayList<>();
            msg.add("上传文件大小超过限制");
            restResult.setMsg(msg);
        } else if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            restResult.setCode(ex.getEm().getCode());
            List<String> msg = new ArrayList<>();
            msg.add(ex.getEm().getMsg());
            restResult.setMsg(msg);
        } else if (e instanceof BindException) {
            org.springframework.validation.BindException ex = (org.springframework.validation.BindException)e;
            List<String> errors = ex.getAllErrors().stream().map(p -> p.getDefaultMessage()).collect(Collectors.toList());
            restResult.setMsg(errors);
            restResult.setCode(ExceptionMsg.ParamError.getCode());
        } else if(e instanceof MethodArgumentNotValidException) {
            List<String> errors = new ArrayList();
            MethodArgumentNotValidException mex = (MethodArgumentNotValidException) e;
            List<ObjectError> allErrors = mex.getBindingResult().getAllErrors();
            for (int i = 0; i < allErrors.size(); i++) {
                errors.add(allErrors.get(i).getDefaultMessage());
            }
            restResult.setMsg(errors);
            restResult.setCode(ExceptionMsg.ParamError.getCode());
        } else if(e instanceof BadSqlGrammarException) {
            BadSqlGrammarException ex = (BadSqlGrammarException) e;
            List<String> msg = new ArrayList<>();
            msg.add(ExceptionMsg.SERVER_ERROR.getMsg());
            msg.add(ex.getCause().getMessage());
            restResult.setMsg(msg);
        } else {
            restResult.setCode(ExceptionMsg.SERVER_ERROR.getCode());
            List<String> msg = new ArrayList<>();
            msg.add(ExceptionMsg.SERVER_ERROR.getMsg());
            msg.add(e.getMessage());
            restResult.setMsg(msg);
            StackTraceElement stackTrace = e.getStackTrace()[0];
            restResult.setErrorMsg("文件名：" + stackTrace.getFileName()+"行："+stackTrace.getLineNumber());
        }
        LogUtil.error("发生异常>>>>>>", "异常原因:" + restResult.toString());
        return restResult;
    }
}
