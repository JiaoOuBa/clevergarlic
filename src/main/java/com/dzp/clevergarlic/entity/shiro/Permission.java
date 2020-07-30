package com.dzp.clevergarlic.entity.shiro;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限许可
 * @Auther ck
 * @Date 2020/7/29 15:07
 * @Desc
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "fc_authority")
public class Permission extends BaseEntity {

    @Id
    private String authId;
    @Column(unique = true)
    private String authCode;  // 权限代码 唯一
    @Column(unique = true)
    private String authName;  //权限名 唯一
    @Column(unique = true)
    private String url;  //访问地址信息 唯一
    private Long adminId;
    private Integer authType;  //权限类型

}
