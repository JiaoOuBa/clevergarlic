package com.dzp.clevergarlic.config.interceptor;

import com.dzp.clevergarlic.config.UserContext;
import com.dzp.clevergarlic.config.annotation.PassToken;
import com.dzp.clevergarlic.config.annotation.UserLoginToken;
import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.AdminUserData;
import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.AuthUserData;
import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.CheckTokenResponse;
import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.AdminUserInfo;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.exception.GlobalException;
import com.dzp.clevergarlic.properties.FcCoreProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * AdminToken拦截器
 * @Auther ck
 * @Date 2020/7/27 14:01
 * @Desc
 */
public class AdminTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private FcCoreProperties fcCoreProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        String tokenStr = request.getHeader(CommonConstant.HEADER_AUTHORIZATION);
        String traceIdStr = request.getHeader(CommonConstant.HEADER_TRACE_ID);
        String platform = request.getHeader(CommonConstant.HEADER_PLATFORM);

        String httpUrl = request.getRequestURI();
        // TODO: 2020/7/27 logger日志记录
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

        // TODO: 2020/7/27 feign掉调用权限系统接口
        /*CheckTokenResponse checkTokenResponse = feign.checkToken(request.getRequestURI());

        String newToken = checkToken(checkTokenResponse, token);

        String adminId = checkTokenResponse.getData().getUserId()+"";

        UserContext.setAdminId(adminId);

        UserContext.getAdminUserToken().set(newToken);

        UserContext.getAdminUserInfo().set(createUserInfo(checkTokenResponse));

        response.setHeader(CommonConstant.HEADER_AUTHORIZATION, newToken);*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception {

    }

    private AdminUserInfo createUserInfo(CheckTokenResponse checkTokenResponse) {

        AdminUserInfo adminUserInfo = new AdminUserInfo();
        AuthUserData authUserData = checkTokenResponse.getData().getUser();

        // 添加用户相关信息
        AdminUserData user = authUserData.getUser();
        adminUserInfo.setAdminId(user.getUserId());
        adminUserInfo.setAdminName(user.getUserName());

        adminUserInfo.setAuth(true);
        return adminUserInfo;
    }

    private String checkToken(CheckTokenResponse checkTokenResponse, String token) {

        // 日志+1

        if (checkTokenResponse == null) {
            throw new GlobalException(ExceptionMsg.LOGINOUT);
        }

        if (!checkTokenResponse.getCode().equals(ExceptionMsg.SUCCESS.getCode())) {
            throw new GlobalException(ExceptionMsg.getCheckTokenException(checkTokenResponse.getCode()));
        }

        String newToken = checkTokenResponse.getToken();
        return StringUtils.isBlank(newToken)? token : newToken.split(" ")[1];
    }

}
