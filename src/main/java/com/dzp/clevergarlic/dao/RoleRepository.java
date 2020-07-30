package com.dzp.clevergarlic.dao;

import com.dzp.clevergarlic.entity.shiro.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 角色数据访问
 * @Auther ck
 * @Date 2020/7/29 15:20
 * @Desc
 */

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
