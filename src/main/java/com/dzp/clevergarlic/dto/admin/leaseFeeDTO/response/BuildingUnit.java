package com.dzp.clevergarlic.dto.admin.leaseFeeDTO.response;

import lombok.Data;

/**
 * 一栋楼的所有单元集合
 * @Auther ck
 * @Date 2020/8/20 16:18
 * @Desc
 */
@Data
public class BuildingUnit {

    private String building;
    private Integer floorCode;
    private String unit;
}
