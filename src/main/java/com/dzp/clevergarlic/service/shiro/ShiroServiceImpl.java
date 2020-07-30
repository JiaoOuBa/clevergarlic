package com.dzp.clevergarlic.service.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Shiro 权限服务
 * @Auther ck
 * @Date 2020/7/29 15:36
 * @Desc
 */
@Service
public class ShiroServiceImpl implements ShiroService{


    @Override
    public ResponseEntity login(String userName, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        subject.login(token);// 执行认证登陆
        return ResponseEntity.ok("{\"message\":\"登陆成功\"}");
    }

    @Override
    public ResponseEntity logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResponseEntity.ok("{\"message\":\"登出成功\"}");
    }
}
