package com.dzp.clevergarlic.service.admin.impl;

import com.dzp.clevergarlic.dao.UserRepository;
import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.AdminUserInfo;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginRequest;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminLoginResponse;
import com.dzp.clevergarlic.dto.admin.loginDTO.AdminToken;
import com.dzp.clevergarlic.entity.shiro.Permission;
import com.dzp.clevergarlic.entity.shiro.User;
import com.dzp.clevergarlic.redis.RedisService;
import com.dzp.clevergarlic.redis.admin.AdminTokenKey;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.service.admin.AdminPermissionService;
import com.dzp.clevergarlic.service.shiro.ShiroService;
import com.dzp.clevergarlic.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    ShiroService shiroService;

    @Autowired
    UserRepository userRepository;


    /**
     * 后台登录
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    @Override
    public ResultVo login(String userName, String password) throws Exception{

        AdminLoginRequest request = AdminLoginRequest.of(userName, password, null);
        User user = userRepository.findByUserName(userName);
        AdminUserInfo userInfo = new AdminUserInfo();
        userInfo.setAdminId(user.getNewUserId());
        userInfo.setAdminName(user.getUserName());

        ResponseEntity lisi = shiroService.login("lisi", "12345");
        HttpStatus statusCode = lisi.getStatusCode();

        // Map<String, List<String>> roleAuth = null;
        List<String> authCodeList = getAuthList(user);

        // 权限模块处理验证账号密码并返回权限list
        AdminLoginResponse response = new AdminLoginResponse();
        response.setAuthList(authCodeList);
        response.setId(user.getNewUserId());
        response.setUserName(user.getUserName());

        Map<String, Object> result = new HashMap<String, Object>(4);

        String token = AdminTokenService.createToken(userInfo.getAdminId(), userName);
        result.put("token", token);
        result.put("admin", response);


        result.put("auth", authCodeList);

        getToken(response,token);
        return Result.success(result);
    }

    private List<String> getAuthList(User user) {

        List<String> authCodeList = new ArrayList<>();
        user.getRoles().forEach(res -> {
            List<Permission> permissions = res.getPermissions();
            List<String> list = new ArrayList<>();
            permissions.forEach(per -> {
                list.add(per.getAuthCode());
            });

            authCodeList.addAll(list);
        });
        return authCodeList;
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
