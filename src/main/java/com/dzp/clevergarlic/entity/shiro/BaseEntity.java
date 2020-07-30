package com.dzp.clevergarlic.entity.shiro;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * 权限基类
 * @Auther ck
 * @Date 2020/7/29 15:15
 * @Desc
 */
@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    /*@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;//创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;//更新时间*/
}
