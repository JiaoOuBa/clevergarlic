package com.dzp.clevergarlic.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.interfaces.Claim;
import com.dzp.clevergarlic.config.UserContext;
import com.dzp.clevergarlic.config.annotation.PassToken;
import com.dzp.clevergarlic.config.annotation.UserLoginToken;
import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.*;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginResponse;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.exception.GlobalException;
import com.dzp.clevergarlic.properties.FcCoreProperties;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.AdminTokenKey;
import com.dzp.clevergarlic.service.admin.impl.*;
import com.dzp.clevergarlic.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * AdminToken拦截器
 * @Auther ck
 * @Date 2020/7/27 14:01
 * @Desc
 */
@Slf4j
public class AdminTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private FcCoreProperties fcCoreProperties;

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String tokenStr = request.getHeader(CommonConstant.HEADER_AUTHORIZATION);
        String traceIdStr = request.getHeader(CommonConstant.HEADER_TRACE_ID);

        String httpUrl = request.getRequestURI();
        log.info("请求路径："+httpUrl);
        UserContext.setUserTraceId(traceIdStr);

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        // 如果没有开启验证，且接口没有UserLoginToken注解则跳过
        if (!fcCoreProperties.getAuth().getOpenToken() && !method.isAnnotationPresent(UserLoginToken.class)) {
            return true;
        }

        // 检查是否有PassToken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        // 执行认证
        if (tokenStr == null || !tokenStr.startsWith(CommonConstant.BEARER_AUTHENTICATION)) {
            throw new GlobalException(ExceptionMsg.LOGINOUT);
        }

        // 从http请求头中取出 token
        String token = tokenStr.split(" ")[1];
        UserContext.getAdminUserToken().set(token);

        TokenInfoResponse adminInfo = checkToken(token);

        String adminId = adminInfo.getAdminId()+"";

        UserContext.setAdminId(adminId);

        UserContext.getLanguageType().set(request.getHeader(CommonConstant.HEADER_LANGUAGE_TYPE));

        UserContext.getAdminUserToken().set(adminInfo.getTokenStr());

        UserContext.getAdminUserInfo().set(createUserInfo(adminInfo));

        response.setHeader(CommonConstant.HEADER_AUTHORIZATION, adminInfo.getTokenStr());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception {

        UserContext.getAdminUserToken().remove();
        UserContext.removeAdminId();
        UserContext.removeUserTraceId();
        UserContext.removeLanguageType();
        UserContext.getAdminUserInfo().remove();
    }

    private AdminUserInfo createUserInfo(TokenInfoResponse adminInfo) {

        AdminUserInfo adminUserInfo = new AdminUserInfo();

        // 添加用户相关信息
        // AdminUserData user = adminUserData;
        adminUserInfo.setAdminId(adminInfo.getAdminId());
        adminUserInfo.setAdminName(adminInfo.getUserName());

        adminUserInfo.setAuth(true);
        return adminUserInfo;
    }

    /**
     * 验证token
     * @param token
     * @return jsonObject 用户信息
     */
    private TokenInfoResponse checkToken(String token) {

        // 日志+1
        LogUtil.info("校验token返回值：", token);

        if (token == null) {
            throw new GlobalException(ExceptionMsg.LOGINOUT);
        }

        Map<String, Claim> tokenMap = AdminTokenService.verifyToken(token);

        Long adminId = tokenMap.get("id").asLong();
        String res = redisService.get(AdminTokenKey.getByToken, adminId + "");
        if (ObjectUtils.isEmpty(res)) {
            throw new GlobalException(ExceptionMsg.LOGINOUT);
        }
        JSONObject jsonObject = JSON.parseObject(res);
        // 将用户信息转换成java对象
        JSONObject obj = (JSONObject) jsonObject.get("adminLoginResponse");
        AdminLoginResponse login = JSONObject.toJavaObject(obj, AdminLoginResponse.class);

        TokenInfoResponse info = TokenInfoResponse.of(login.getId(), login.getUserName(), jsonObject.get("adminToken").toString());
        log.info("token返回值："+info.toString());
        return info;
    }

}
