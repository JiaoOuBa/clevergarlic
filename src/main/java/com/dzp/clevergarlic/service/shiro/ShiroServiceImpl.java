package com.dzp.clevergarlic.service.shiro;

import com.dzp.clevergarlic.dao.UserRepository;
import com.dzp.clevergarlic.dto.admin.shiroDTO.AddUser;
import com.dzp.clevergarlic.entity.shiro.User;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.util.IdUtil.Sid;
import com.dzp.clevergarlic.util.LongIdUtil;
import com.dzp.clevergarlic.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    Sid sid;

    @Autowired
    UserRepository userRepository;


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

    @Override
    public ResultVo addUser(AddUser addUser) {

        User byUserName = userRepository.findByUserName(addUser.getUserName());
        if (byUserName != null && byUserName.getStatus() == 1) {
            throw new RuntimeException("用户已存在！");
        }

        User user = new User();
        user.setUserId(sid.nextShort());
        user.setNewUserId(LongIdUtil.uuId());
        user.setUserName(addUser.getUserName());

        // 加密后的密码
        String encrypt = String.valueOf(ShiroUtil.encrypt(addUser.getUserName(), addUser.getPassword()));
        user.setPassword(encrypt);

        User save = userRepository.save(user);
        return null;
    }

    /**
     * 根据userId获取用户信息
     * @param newUserId
     * @return
     */
    @Override
    public String getUserName(Long newUserId) {

        if (newUserId == null) {
            return null;
        }
        User userInfo = userRepository.findByNewUserId(newUserId);
        if (userInfo == null) {
            throw new RuntimeException("用户不存在");
        }
        return userInfo.getUserName();
    }

    /**
     * 根据用户名获取userId
     * @param userName
     * @return
     */
    @Override
    public Long getNewUserId(String userName) {
        if (userName == null) {
            return null;
        }
        User userInfo = userRepository.findByUserName(userName);
        if (userInfo == null) {
            throw new RuntimeException("用户不存在");
        }
        return userInfo.getNewUserId();
    }
}
