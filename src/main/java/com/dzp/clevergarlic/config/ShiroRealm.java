package com.dzp.clevergarlic.config;

import com.dzp.clevergarlic.dto.common.user.User;
import com.dzp.clevergarlic.enums.UserEnum;
import com.dzp.clevergarlic.mapper.admin.AdminUserMapper;
import com.dzp.clevergarlic.util.AESUtil;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * 自定义Realm
 * @Auther ck
 * @Date 2020/7/9 13:59
 * @Desc
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    AdminUserMapper userMapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String userName = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        System.out.println("用户" + userName + "认证-----ShiroRealm.doGetAuthenticationInfo");
        User user = userMapper.getUserByName(userName);
        if (ObjectUtils.isEmpty(user)) {
            throw new UnknownAccountException("用户名不存在");
        }

        if (!user.getPassword().equals(password)) {
            throw new IncorrectCredentialsException("用户名或密码错误");
        }
        if (!UserEnum.USER_JH.getCode().equals(user.getStatus())) {
            throw new LockedAccountException("用户已被冻结");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
