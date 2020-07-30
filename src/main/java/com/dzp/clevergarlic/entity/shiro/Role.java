package com.dzp.clevergarlic.entity.shiro;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * 角色（role）
 * @Auther ck
 * @Date 2020/7/29 15:16
 * @Desc
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "fc_role")
public class Role extends BaseEntity {

    @Id
    private String roleId;

    @Column(unique = true)
    private String roleName; //角色名 唯一

    @ManyToMany(fetch= FetchType.EAGER)
    private List<Permission> permissions; //一个用户角色对应多个权限
}
