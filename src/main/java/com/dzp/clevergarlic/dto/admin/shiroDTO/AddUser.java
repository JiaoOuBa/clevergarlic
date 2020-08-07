package com.dzp.clevergarlic.dto.admin.shiroDTO;

import lombok.Data;

/**
 * @Auther ck
 * @Date 2020/8/5 15:28
 * @Desc
 */

@Data
public class AddUser {

    /**
     * 主键id
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户id
     */
    private Long newUserId;


    public static AddUser of(String userName, String password) {
        AddUser user = new AddUser();
        user.setUserName(userName);
        user.setPassword(password);
        return user;
    }
}
