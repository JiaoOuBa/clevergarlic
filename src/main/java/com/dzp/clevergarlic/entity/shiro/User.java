package com.dzp.clevergarlic.entity.shiro;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * 用户
 * @Auther ck
 * @Date 2020/7/29 15:17
 * @Desc
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "fc_user")
public class User extends BaseEntity {

    @Id
    private String userId;

    @Column(unique = true)
    private String userName;//用户名 唯一
    private String password;//用户密码
    private String passwordSalt;//用户密码加密盐值
    private Integer status;
    private Long newUserId;// 最终用户id
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;//用户角色  一个用户可能有一个角色，也可能有 多个角色

}
