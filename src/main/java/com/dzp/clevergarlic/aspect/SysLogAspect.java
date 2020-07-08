package com.dzp.clevergarlic.aspect;

import cn.hutool.core.util.IdUtil;
import com.dzp.clevergarlic.config.annotation.Log;
import com.dzp.clevergarlic.dto.admin.logdto.SysLogRequest;
import com.dzp.clevergarlic.mapper.SysLogMapper;
import com.dzp.clevergarlic.util.HttpContextUtil;
import com.dzp.clevergarlic.util.IPUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * aop执行写入系统日志
 * @Auther ck
 * @Date 2020/7/6 10:23
 * @Desc
 */

@Aspect
@Component
public class SysLogAspect {

    @Autowired
    SysLogMapper sysLogMapper;

    @Pointcut("@annotation(com.dzp.clevergarlic.config.annotation.Log)")
    public void pointcut() {}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            result = point.proceed();
            // 记录执行时间(ms)
            long time = System.currentTimeMillis() - beginTime;
            // 保存成功日志
            SysLogRequest log = saveLog(point, time);
            sysLogMapper.saveLog(log);

        } catch (Throwable e) {
            // 捕获异常并写入
            doException(point, e);
        }

        return result;
    }

    private void doException(ProceedingJoinPoint point, Throwable e) {
        SysLogRequest error = saveLog(point, 0);
        error.setErrorMsg("异常描述：" + e.getMessage() + "，错误信息：" + e.getStackTrace()[0].toString());
        sysLogMapper.saveLog(error);
    }

    private SysLogRequest saveLog(ProceedingJoinPoint point, long time) {

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLogRequest log = new SysLogRequest();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            log.setOperation(logAnnotation.value());
        }

        // 请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setMethod(className + "." + methodName + "()");

        // 请求的参数-参数值
        Object[] args = point.getArgs();

        // 请求的参数-参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] argsNames = u.getParameterNames(method);
        if (args != null && argsNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += " " + argsNames[i] + ":" + args[i];
            }
            log.setParams(params);
        }

        // 获取request
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        log.setIp(IPUtil.getIpAddr(request));

        // 一个虚假的用户
        log.setUserId(007);
        log.setUserName("lilei");

        // 方法的执行时间
        log.setTime((int) time);

        // 主键id
        log.setLogId(IdUtil.objectId());

        // 创建时间
        //log.setCreateTime();

        return log;
    }
}
