package com.dzp.clevergarlic.service.impl;

import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.AdminUserInfo;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginRequest;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginResponse;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminToken;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.AdminTokenKey;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.AdminPermissionService;
import com.dzp.clevergarlic.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台权限控制
 * @Auther ck
 * @Date 2020/7/28 15:47
 * @Desc
 */
@Service
public class AdminPermissionServiceImpl implements AdminPermissionService {

    @Autowired
    RedisService redisService;


    /**
     * 后台登录
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ResultVo login(String userName, String password) throws Exception{

        AdminLoginRequest request = AdminLoginRequest.of(userName, password, null);
        AdminUserInfo userInfo = null;

        // 权限模块处理验证账号密码并返回权限list
        AdminLoginResponse response = null;

        Map<String, Object> result = new HashMap<String, Object>(4);

        String token = AdminTokenService.createToken(userInfo.getAdminId(), userName).split(" ")[1];
        result.put("token", token);
        result.put("admin", response);

        Map<String, List<String>> roleAuth = null;
        result.put("auth", roleAuth.get("auth"));

        getToken(response,token);
        return Result.success(result);
    }

    /**
     * 获取token并存redis
     * @param response
     * @param token
     * @return
     */
    private String getToken(AdminLoginResponse response, String token) {

        /*获取token并存储，默认过期时间7200秒*/
        String insertTime = CommonUtil.getDateTimeNow();

        AdminToken adminToken = new AdminToken();
        adminToken.setAdminLoginResponse(response);
        adminToken.setAdminToken(token);
        adminToken.setInsertTime(insertTime);

        // 存到redis
        AdminTokenKey atk = AdminTokenKey.getByToken;
        redisService.set(atk, response.getId() + "", adminToken);

        return token;
    }

}
