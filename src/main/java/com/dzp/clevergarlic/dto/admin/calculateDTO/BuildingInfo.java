package com.dzp.clevergarlic.dto.admin.calculateDTO;

import lombok.Data;

import java.util.List;

/**
 * @Auther ck
 * @Date 2020/8/5 11:42
 * @Desc
 */

@Data
public class BuildingInfo {

    /**
     * 楼宇id
     */
    private String buildingId;

    /**
     * 楼宇名称
     */
    private String buildingName;

    /**
     * 租金参数集合
     */
    private List<Object> leaseParams;

    /**
     * 招商参数集合
     */
    private List<Object> businessParams;
}
