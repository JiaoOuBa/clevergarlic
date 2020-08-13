package com.dzp.clevergarlic.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Auther ck
 * @Date 2020/8/7 14:20
 * @Desc
 */
@Controller
public class BaseController {

    /**
     * 获取请求头语言类型-type
     * @return
     */
    public String getLanguageType() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        return request.getHeader("type");
    }
}
