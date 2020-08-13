package com.dzp.clevergarlic.service.shiro;

import com.dzp.clevergarlic.dto.admin.shiroDTO.AddUser;
import com.dzp.clevergarlic.entity.shiro.User;
import com.dzp.clevergarlic.result.ResultVo;
import org.springframework.http.ResponseEntity;

/**
 * Shiro 权限服务
 * @Auther ck
 * @Date 2020/7/29 15:34
 * @Desc
 */
public interface ShiroService {

    /**
     * 用户登陆服务
     *
     * 1 . 传入用户名/密码
     * 2 . Shiro 登陆校验 ,加载数据库中用户的角色，权限。
     * @param userName 传入的用户名
     * @param password 传入的密码(明文)
     */
    ResponseEntity login(String userName, String password);

    ResponseEntity logout();

    /**
     * 添加用户
     * @return
     */
    ResultVo addUser(AddUser addUser);

    /**
     * 根据userId获取用户名
     * @param newUserId
     * @return
     */
    String getUserName(Long newUserId);

    /**
     * 根据用户名获取userId
     * @param userName
     * @return
     */
    Long getNewUserId(String userName);
}
