package com.dzp.clevergarlic.dto.admin.calculateDTO;

import lombok.Data;

/**
 * @Auther ck
 * @Date 2020/8/5 13:42
 * @Desc
 */

@Data
public class VersionInfo {

    /**
     * 主键id
     */
    private String columnId;
    /**
     * 计划版本
     */
    private String planVersion;
    /***
     * 租金版本
     */
    private String leaseVersion;
    /**
     * 招商版本
     */
    private String businessVersion;
}
