package com.dzp.clevergarlic.dao;

import com.dzp.clevergarlic.entity.shiro.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户数据访问
 * @Auther ck
 * @Date 2020/7/29 15:21
 * @Desc
 */

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    User findByNewUserId(Long newUserId);
}
