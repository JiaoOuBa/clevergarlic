package com.dzp.clevergarlic.service;

import com.dzp.clevergarlic.result.ResultVo;

/**
 * 后台权限控制
 * @Auther ck
 * @Date 2020/7/28 15:46
 * @Desc
 */
public interface AdminPermissionService {

    /**
     * 后台登录
     * @param userName 用户名
     * @param password 密码
     * @return ResultVo
     */
    ResultVo login(String userName, String password) throws Exception;
}
