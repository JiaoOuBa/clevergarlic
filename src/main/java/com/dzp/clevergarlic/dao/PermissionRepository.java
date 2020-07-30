package com.dzp.clevergarlic.dao;

import com.dzp.clevergarlic.entity.shiro.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 权限数据访问
 * @Auther ck
 * @Date 2020/7/29 15:19
 * @Desc
 */

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Permission findByAuthName(String authName);
}
